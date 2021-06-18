/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecagrupo3.Controllers;
import bibliotecaGrupo3.Controllers.Conexion;
import bibliotecagrupo3.Models.Lector;
import bibliotecagrupo3.Models.Prestamo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * Gustavo
 */
public class LectorData {
     private Connection conexion;
     
     public LectorData(Conexion conexion) throws SQLException{
         this.conexion = conexion.getConexion();
     }
     
     public void guardarLector(Lector lector){
        String query = "INSERT INTO `lector`(`dni`, `direccion`, `nombre`, `apellido`, `estado`) VALUES (?,?,?,?,?)";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            
            ps.setInt(1, lector.getDni());
            ps.setString(2, lector.getDireccion());
            ps.setString(3, lector.getNombre());
            ps.setString(4, lector.getApellido());
            ps.setBoolean(5, lector.isEstado());
            
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Lector guardado con exito");
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al guardar el lector"+ex.getMessage());
        }
    }
    
    public Lector buscarLector(int dni){
        Lector lector = null;
        
        String query = "SELECT * FROM `lector` WHERE dni=?";

        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            
            ps.setInt(1, dni);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                lector = new Lector();
                
                lector.setDni(rs.getInt("dni"));
                lector.setNombre(rs.getString("nombre"));
                lector.setApellido(rs.getString("apellido"));
                lector.setDireccion(rs.getString("direccion"));
                lector.setEstado(rs.getBoolean("estado"));
                
            } else {
                JOptionPane.showMessageDialog(null,"Lector no encontrado.");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar lector."+ex.getMessage());
        }
        
        return lector;
    }
    
    public ArrayList<Lector> getPrestamoVencido(){
        ArrayList<Lector> lista = new ArrayList<>();
        
        String query = "SELECT `dni`, `direccion`, `nombre`, `apellido` FROM `lector`,prestamo, ejemplar WHERE lector.dni=prestamo.dni_lector "
                + "and prestamo.id_ejemplar=ejemplar.id_ejemplar and prestamo.estado=1 "
                + "and (ejemplar.estado= 'retrasado' or (date_add(prestamo.fecha, interval 1 month) < current_date)) ";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Lector lector = new Lector();
                
                lector.setDni(rs.getInt("dni"));
                lector.setDireccion(rs.getString("direccion"));
                lector.setNombre(rs.getString("nombre"));
                lector.setApellido(rs.getString("apellido"));
                lector.setEstado(true);
                lista.add(lector);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar lectores. "+ex.getMessage());
        }
        
        return lista;
    }

    public ArrayList<Lector> getConMulta(int mes){
        ArrayList<Lector> lista = new ArrayList<>();
        
        String query = "SELECT `dni`, `direccion`, `nombre`, `apellido`, lector.estado FROM `lector`, prestamo, multa " +
                        "WHERE lector.dni=prestamo.dni_lector " +
                        "and prestamo.id_multa=multa.id_multa " +
                        "and MONTH(multa.fecha_inicio)=? " +
                        "and MONTH(multa.fecha_fin)=?";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            
            ps.setInt(1, mes);
            ps.setInt(2, mes);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Lector lector = new Lector();
                
                lector.setDni(rs.getInt("dni"));
                lector.setDireccion(rs.getString("direccion"));
                lector.setNombre(rs.getString("nombre"));
                lector.setApellido(rs.getString("apellido"));
                lector.setEstado(true);
                lista.add(lector);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar lectores."+ex.getMessage());
        }
        
        return lista;
    }
    
    public void desactivarLector(int dni) throws ClassNotFoundException, SQLException{
        Conexion con = new Conexion();
        
        PrestamoData prestamoData = new PrestamoData(con);
        
        ArrayList <Prestamo> lista = prestamoData.getByLector(this.buscarLector(dni));
        
        for(Prestamo prestamo:lista){
            if(prestamo.isEstado()&&(ChronoUnit.DAYS.between(prestamo.getFecha(), LocalDate.now())>90)){
                
                    String query = "UPDATE lector SET estado = false WHERE dni = ? ";
        
                    try {
                        PreparedStatement ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                        ps.setInt(1, dni);
                      
                        if(ps.executeUpdate() == 1){
                            JOptionPane.showMessageDialog(null,"lector dado de baja");
                        }else {
                            JOptionPane.showMessageDialog(null,"El lector al que le quiere dar la baja no existe");
                        }
            
                        ps.close();
                        return;
                    } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"Error al dar de baja a un lector. SQL");
                    }
                    
                }

            }
        
            JOptionPane.showMessageDialog(null, "El lector no cumple las condiciones para la baja");
    }
    
    // En este metodo se dan de alta los lectores que fueron dados de baja previamente
    public void activarLector(int dni)throws SQLException, ClassNotFoundException{
        
        Conexion con = new Conexion();
        
        PrestamoData prestamoData = new PrestamoData(con);
        
        ArrayList <Prestamo> lista = prestamoData.getByLector(this.buscarLector(dni));
        
        for(Prestamo prestamo:lista){
            if((prestamo.getMulta().getId_multa()!=0)&&(ChronoUnit.DAYS.between(prestamo.getMulta().getFecha_fin(), LocalDate.now())<=0)||(prestamo.isEstado())){

                    JOptionPane.showMessageDialog(null, "Aun no se le puede activar, tiene irregularidades");
                    return;
            }
        }
        
        String query = "UPDATE lector SET estado = true WHERE dni = ? ";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dni);
                      
            if(ps.executeUpdate() == 1){
                JOptionPane.showMessageDialog(null,"lector dado de alta");
            }else {
                JOptionPane.showMessageDialog(null,"El lector al que le quiere dar el alta no existe");
            }
            
            ps.close();
    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al dar de alta a un lector. SQL");
        }
    }
    // solamente se permite modificar los lectores que estan dados de alta
    public void modificarLector(Lector lector){
        String query = "UPDATE `lector` SET `direccion`=?,`nombre`=?,`apellido`=? WHERE dni=? and estado = 1";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            
            ps.setString(1, lector.getDireccion());
            ps.setString(2, lector.getNombre());
            ps.setString(3, lector.getApellido());
            ps.setInt(4, lector.getDni());
            if(ps.executeUpdate() == 1){
                JOptionPane.showMessageDialog(null,"Lector actualizado con exito.");
            } else {
                JOptionPane.showMessageDialog(null,"El lector no se pudo actualizar.");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al guardar el lector."+ex.getMessage());
        }
    }
}
