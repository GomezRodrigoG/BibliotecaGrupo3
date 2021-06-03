/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecagrupo3.Controllers;

import bibliotecagrupo3.Models.Lector;
import bibliotecagrupo3.Models.Prestamo;
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
    //TODO subir la version actualizada de la bd
    private Conexion conexion ;

    public PrestamoData(Conexion conexion) throws SQLException {
        this.conexion = conexion.getConexion();
    }
    
    public void guardarPrestamo(Prestamo prestamo){
        // id_prestamo | id_multa | id_ejemplar | dni_lector | estado | fecha | fecha_devolucion
        String query = "INSERT INTO prestamo VALUES (null, null, ?, ?, true, ?, null)";
        
        try {
            PreparedStatement statement = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            /*
            statement.setString(1, materia.getNombre_materia());
            statement.setInt(2, materia.getAnio());
            statement.setBoolean(3, materia.isEstado());
            */
            statement.executeUpdate();
            
            ResultSet rSet = statement.getGeneratedKeys();
            
            if(rSet.next()){
                // materia.setId_materia(rSet.getInt(1));
                JOptionPane.showMessageDialog(null,"Materia guardada correctamente.");
            } else {
                JOptionPane.showMessageDialog(null,"No se guardo.");
            }
            
            statement.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al guardar una materia.");
        }
    }
    
    public Prestamo buscarPrestamo(int id){
        
        return null;
    }

    public void borrarPrestamo(int id){
        
    }
    
    public void modificarPrestamo(Prestamo prestamo){
        
    }
    
    public ArrayList<Prestamo> getPrestamoByDate(LocalDate fecha){
        return null;
    }
    
    public ArrayList<Prestamo> getPrestamosByLector(Lector lector){
        return null;
    }
}
