/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecagrupo3.Controllers;

import bibliotecaGrupo3.Controllers.Conexion;
import bibliotecagrupo3.Models.Ejemplar;
import bibliotecagrupo3.Models.Lector;
import bibliotecagrupo3.Models.Multa;
import bibliotecagrupo3.Models.Prestamo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 *  Rodrigo
 */
public class PrestamoData {
    private Connection conexion;
    private MultaData mData;
    private EjemplarData eData;
    private LectorData lData;
    
    public PrestamoData(Conexion conexion) throws SQLException {
        this.conexion = conexion.getConexion();
        mData = new MultaData(conexion);
        eData = new EjemplarData(conexion);
        lData = new LectorData(conexion);
    }
    
    //Crear un nuevo prestamo
    public void crear(Prestamo prestamo){
        // id_prestamo | id_multa | id_ejemplar | dni_lector | estado | fecha | fecha_devolucion
        String query = "INSERT INTO prestamo VALUES (null, null, ?, ?, true, ?, null)";
        
        try {
            PreparedStatement statement = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            int idEjemplar = prestamo.getEjemplar().getId_ejemplar();
            int dniLector = prestamo.getLector().getDni();
            
            statement.setInt(1, idEjemplar);
            statement.setInt(2, dniLector);
            statement.setDate(3, Date.valueOf(LocalDate.now()));
            
            statement.executeUpdate();
            
            ResultSet rSet = statement.getGeneratedKeys();
            
            if(rSet.next()){
                prestamo.setId_prestamo(rSet.getInt(1));
                JOptionPane.showMessageDialog(null,"Prestamo guardado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null,"No se guardo.");
            }
            
            statement.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al guardar un prestamo.");
        }
    }
    /**
    * Buscar un prestamo por su id en la base
    */
    public Prestamo buscar(int id){
        String query="select * from prestamo where id_prestamo = ?";
        Prestamo toRet = null;
        
        try {
            PreparedStatement statement = conexion.prepareStatement(query); 
            statement.setInt( 1, id);
            
            ResultSet rSet = statement.executeQuery();
            
            if(rSet.next()){
                toRet = new Prestamo();
                Date auxDate = rSet.getDate("fecha_devolucion");
                
                if(auxDate != null){
                    toRet.setFecha_devolucion(auxDate.toLocalDate());
                } else {
                    toRet.setFecha_devolucion(null);
                }
                
                int auxMultaValue = rSet.getInt("id_multa");
                
                if(auxMultaValue != 0){
                    Multa auxMulta = mData.buscarMulta(auxMultaValue);
                    toRet.setMulta(auxMulta);
                } else {
                    toRet.setMulta(null);
                }
                
                toRet.setId_prestamo(rSet.getInt("id_prestamo"));
                
                Ejemplar auxEjemplar = eData.buscarEjemplar(rSet.getInt("id_ejemplar"));
                toRet.setEjemplar(auxEjemplar);
                
                Lector auxLector = lData.buscarLector(rSet.getInt("dni_lector"));
                toRet.setLector(auxLector);
                
                toRet.setEstado(rSet.getBoolean("estado"));
                toRet.setFecha(rSet.getDate("fecha").toLocalDate());
            }else{
                JOptionPane.showMessageDialog(null,"Prestamo no encontrado.");
            }

            statement.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al Buscar el prestamo.");;
        }
        
        return toRet;
    }
    
    //Dar de baja un prestamo manualmente
    public void borrar(int id){
        String query = "UPDATE prestamo SET estado = false WHERE id_prestamo = ? ";
        
        try {
            PreparedStatement statement = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
                      
            if(statement.executeUpdate() == 1){
                JOptionPane.showMessageDialog(null,"Prestamo dado de baja");
            }else {
                JOptionPane.showMessageDialog(null,"El prestamo al que quiere dar de baja no existe.");
            }
            
            statement.close();
    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al dar de baja un prestamo.");
        }
    }
    
    // este metodo va a permitir modificar en caso de cargar mal un prestamo
    public void modificar(Prestamo prestamo){
        // id_prestamo | id_multa | id_ejemplar | dni_lector | estado | fecha | fecha_devolucion
        String query = "UPDATE prestamo SET id_ejemplar=?, dni_lector=? WHERE id_prestamo = ?";
        
        try {
            PreparedStatement statement = conexion.prepareStatement(query);
            
            int idEjemplar = prestamo.getEjemplar().getId_ejemplar();
            int dniLector = prestamo.getLector().getDni();
            
            statement.setInt(1, idEjemplar);
            statement.setInt(2, dniLector);
            statement.setInt(3, prestamo.getId_prestamo());
            
            if(statement.executeUpdate() == 1){
                JOptionPane.showMessageDialog(null,"Prestamo actualizado con exito.");
            } else {
                JOptionPane.showMessageDialog(null,"El prestamo no se pudo actualizar.");
            }
        } catch (SQLException ex) {
            String msg = "Error al actualizar un prestamo." + ex.getMessage();
            
            JOptionPane.showMessageDialog(null,msg);
        }
    }
    
    // este metodo permite a un usuario devolver un prestamo al cual se le genero una multa desde la vista
    public void devolverConMulta(Prestamo prestamo){
        // id_prestamo | id_multa | id_ejemplar | dni_lector | estado | fecha | fecha_devolucion
        String query = "UPDATE prestamo SET id_multa = ?, fecha_devolucion = ? WHERE id_prestamo = ?";
        
        try {
            PreparedStatement statement = conexion.prepareStatement(query);
            
            Multa multa = prestamo.getMulta();
            
            statement.setInt(1, multa.getId_multa());
            statement.setDate(2, Date.valueOf(prestamo.getFecha_devolucion()));
            statement.setInt(3, prestamo.getId_prestamo());
            
            if(statement.executeUpdate() == 1){
                JOptionPane.showMessageDialog(null,"Prestamo devuelto con exito.");
            } else {
                JOptionPane.showMessageDialog(null,"El prestamo no se pudo devolver.");
            }
        } catch (SQLException ex) {
            String msg = "Error al actualizar un prestamo." + ex.getMessage();
            
            JOptionPane.showMessageDialog(null,msg);
        }
    }
    
    // este metodo permite a un usuario devolver un prestamo al cual NO se le genero una multa desde la vista
    public void devolverSinMulta(Prestamo prestamo){
        // id_prestamo | id_multa | id_ejemplar | dni_lector | estado | fecha | fecha_devolucion
        String query = "UPDATE prestamo SET fecha_devolucion = ? WHERE id_prestamo = ?";
        
        try {
            PreparedStatement statement = conexion.prepareStatement(query);
            
            statement.setDate(1, Date.valueOf(prestamo.getFecha_devolucion()));
            statement.setInt(2, prestamo.getId_prestamo());
            
            if(statement.executeUpdate() == 1){
                JOptionPane.showMessageDialog(null,"Prestamo devuelto con exito.");
            } else {
                JOptionPane.showMessageDialog(null,"El prestamo no se pudo devolver.");
            }
        } catch (SQLException ex) {
            String msg = "Error al actualizar un prestamo." + ex.getMessage();
            
            JOptionPane.showMessageDialog(null,msg);
        }
    }
    
    // metodo que dada una fecha devuelve todos los prestamos del mes
    public ArrayList<Prestamo> getByDate(LocalDate fecha){
        // valores por parametro
        // 1 = fecha de inicio
        // 2 = fecha de fin
        String query = "SELECT `id_prestamo`, `id_multa`, `id_ejemplar`, `dni_lector`, `estado`, `fecha`, `fecha_devolucion` FROM `prestamo` WHERE fecha >= ? AND fecha <= ?";
        ArrayList<Prestamo> toRet = new ArrayList<>();
        
        try {
            LocalDate fechaInicio = fecha.withDayOfMonth(1);
            LocalDate fechaFin = fecha.withDayOfMonth(fecha.lengthOfMonth());
            
            PreparedStatement statement = conexion.prepareStatement(query);
            
            statement.setDate(1, Date.valueOf(fechaInicio));
            statement.setDate(2, Date.valueOf(fechaFin));
            
            ResultSet rSet = statement.executeQuery();
            
            llenarListaDePrestamos(rSet, toRet);
            
        } catch (SQLException ex) {
            String resp = "Error al buscar los prestamos" + ex.getMessage();
            JOptionPane.showMessageDialog(null,resp);;
        }
        
        return toRet;
    }
    
    // metodo que dado un lector devuelve todos sus prestamos
    public ArrayList<Prestamo> getByLector(Lector lector){
        System.out.println(lector);
        String query = "SELECT `id_prestamo`, `id_multa`, `id_ejemplar`, `dni_lector`, `estado`, `fecha`, `fecha_devolucion` FROM `prestamo` WHERE dni_lector = ?";
        ArrayList<Prestamo> toRet = new ArrayList<>();
        
        try {
            PreparedStatement statement = conexion.prepareStatement(query);
            
            statement.setInt(1, lector.getDni());
            
            ResultSet rSet = statement.executeQuery();
            
            llenarListaDePrestamos(rSet, toRet);
            
        } catch (SQLException ex) {
            String resp = "Error al buscar los prestamos" + ex.getMessage();
            JOptionPane.showMessageDialog(null,resp);
        }
        
        return toRet;
    }
    
    // metodo privado utilizado por getByDate y getByLector
    // recibe el ResultSet y un arreglo por parametro y llena el arreglo con sus datos correspondientes
    private void llenarListaDePrestamos(ResultSet rSet, ArrayList<Prestamo> prestamosArr){
        Prestamo auxPrestamo;
        try {
            while(rSet.next()){
                auxPrestamo = new Prestamo();
                Date auxDate = rSet.getDate("fecha_devolucion");
                
                if(auxDate != null){
                    auxPrestamo.setFecha_devolucion(auxDate.toLocalDate());
                } else {
                    auxPrestamo.setFecha_devolucion(null);
                }
                
                int auxMultaValue = rSet.getInt("id_multa");
                
                if(auxMultaValue != 0){
                    Multa auxMulta = mData.buscarMulta(auxMultaValue);
                    auxPrestamo.setMulta(auxMulta);
                } else {
                    auxPrestamo.setMulta(null);
                }
                
                auxPrestamo.setId_prestamo(rSet.getInt("id_prestamo"));
                
                Ejemplar auxEjemplar = eData.buscarEjemplar(rSet.getInt("id_ejemplar"));
                auxPrestamo.setEjemplar(auxEjemplar);
                
                Lector auxLector = lData.buscarLector(rSet.getInt("dni_lector"));
                auxPrestamo.setLector(auxLector);
                
                auxPrestamo.setEstado(rSet.getBoolean("estado"));
                auxPrestamo.setFecha(rSet.getDate("fecha").toLocalDate());
                
                prestamosArr.add(auxPrestamo);
            }
            
        } catch (SQLException ex) {
            String resp = "Error al buscar los prestamos" + ex.getMessage();
            JOptionPane.showMessageDialog(null,resp);
        }
    }
}
