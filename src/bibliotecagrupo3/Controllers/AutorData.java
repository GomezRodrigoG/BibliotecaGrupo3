/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecagrupo3.Controllers;


import bibliotecagrupo3.Models.Autor;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import bibliotecaGrupo3.Controllers.Conexion;
/**
 *
 * Nahuel
 */
public class AutorData {
    private Connection con ;
    
    public AutorData(Conexion conexion) throws SQLException {
        this.con = conexion.getConexion();
    }
    public void guardarAutor(Autor a){
        try {
            String query = "INSERT INTO autor (dni, nombre, apellido, fecha_nac, nacionalidad) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps= con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, a.getDni());
            ps.setString(2, a.getNombre());
            ps.setString(3, a.getApellido());
            ps.setDate(4, Date.valueOf(a.getFecha_nac()));
            ps.setString(5, a.getNacionalidad());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
            a.setId_autor(rs.getInt(1));
            JOptionPane.showMessageDialog(null, "Autor Agregado");
            }
            else{
            JOptionPane.showMessageDialog(null, "No se pudo guardar id no guardado");
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error SQL");
        }
       
    }
    public void eliminarAutor(int dni){
        try {
            String query ="DELETE FROM autor WHERE dni=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1, dni);
            if(ps.executeUpdate()==1){
            JOptionPane.showMessageDialog(null, "Autor borrado");
            }else{
            JOptionPane.showMessageDialog(null, "Autor NO eliminado");}
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error SQL");
        }    
}
    public void modificarAutor(Autor autor){
        try {
            String query = "UPDATE autor SET  nombre=?, apellido=?, fecha_nac=?, nacionalidad=? WHERE dni=?";
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1, autor.getNombre());
            ps.setString(2, autor.getApellido());
            ps.setDate(3, Date.valueOf(autor.getFecha_nac()));
            ps.setString(4, autor.getNacionalidad());
            ps.setInt(5, autor.getDni());
            ps.executeUpdate();
            if(ps.executeUpdate()==1){
            JOptionPane.showMessageDialog(null, "Autor Actualizado");}
            else {
            JOptionPane.showMessageDialog(null, "No se Pudo actualizar el autor");}
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error SQL");
        }
    }
    /*public void bajaLogica(int dni){
        String query = "UPDATE alumno SET estado=false"
    }*/
    
    
}
