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
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 *  Rodrigo
 */
public class PrestamoData {
    private Connection conexion;

    public PrestamoData(Conexion conexion) throws SQLException {
        this.conexion = conexion.getConexion();
    }
    
    public void crear(Prestamo prestamo){
        // id_prestamo | id_multa | id_ejemplar | dni_lector | estado | fecha | fecha_devolucion
        String query = "INSERT INTO prestamo VALUES (null, null, ?, ?, true, ?, null)";
        
        try {
            PreparedStatement statement = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            //TODO activar esto cuando este el ejemplar listo
            // statement.setInt(1, prestamo.getEjemplar().getId_ejemplar());
            statement.setInt(1, 6);
            
            //TODO activar esto cuando este el lector listo
            // statement.setInt(2, prestamo.getLector().getDni());
            statement.setInt(2,91234567);
            
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
    
    public Prestamo buscar(int id){
        //TODO pensar si realmente es necesario este metodo
        return null;
    }

    public void borrar(int id){
        String query = "UPDATE prestamo SET estado = false WHERE id_prestamo = ? ";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
                      
            if(ps.executeUpdate() == 1){
                JOptionPane.showMessageDialog(null,"Prestamo dado de baja");
            }else {
                JOptionPane.showMessageDialog(null,"El prestamo al que quiere dar de baja no existe.");
            }
            
            ps.close();
    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al dar de baja un prestamo.");
        }
    }
    
    // este metodo va a permitir modificar en caso de cargar mal un prestamo
    public void modificar(Prestamo prestamo){
        
    }
    
    public void devolver(int id){
        
    }
    
    public ArrayList<Prestamo> getByDate(LocalDate fecha){
        return null;
    }
    
    public ArrayList<Prestamo> getByLector(Lector lector){
        return null;
    }
}
