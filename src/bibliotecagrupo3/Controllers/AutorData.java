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
import java.util.ArrayList;
import java.util.List;
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
    public Autor buscarAutor(int dni){
        String query = "SELECT * FROM autor WHERE autor.dni = ?";
            Autor autor=null;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            autor = new Autor();
            autor.setId_autor(rs.getInt("id_autor"));
            autor.setDni(rs.getInt("dni"));
            autor.setNombre(rs.getString("nombre"));
            autor.setApellido(rs.getString("apellido"));
            autor.setFecha_nac(rs.getDate("fecha_nac").toLocalDate());
            autor.setNacionalidad(rs.getString("nacionalidad"));
            }
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AutorData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return autor;
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
    
    
    public List<Autor> getAllAutores(){
        String query="SELECT * FROM autor ";
        Autor autor;
        List<Autor> autores = new ArrayList<>();
        
        try {
            PreparedStatement ps = con.prepareStatement(query); 
                 ResultSet rs=ps.executeQuery();
                while(rs.next()){
                    autor = new Autor();
                    autor.setId_autor(rs.getInt("id_autor"));
                    autor.setDni(rs.getInt("dni"));
                    autor.setNombre(rs.getString("nombre"));
                    autor.setApellido(rs.getString("apellido"));
                    autor.setFecha_nac(rs.getDate("fecha_nac").toLocalDate());
                    autor.setNacionalidad(rs.getString("nacionalidad"));
                    autores.add(autor);
                
            }
             ps.close();
            
        } catch (SQLException ex ) {
            JOptionPane.showMessageDialog(null, "Error SQL");
        }
        
        return autores;
        
    }
    
    
    
}
