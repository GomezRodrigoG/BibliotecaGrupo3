/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecagrupo3.Controllers;

import bibliotecagrupo3.Models.Ejemplar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import bibliotecaGrupo3.Controllers.Conexion;
import java.util.ArrayList;

/**
 *
 * Pablo
 */
public class EjemplarData {
      private Connection  conexion ;

    public EjemplarData(Conexion conexion) throws SQLException {
        this.conexion = conexion.getConexion();
    }
    
    
    public void guardarEjemplar(Ejemplar ejemplar){
        
        String query = "INSERT INTO ejemplar VALUES (null,?,?)";
        
        try {
            PreparedStatement statement = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            
            statement.setString(1,ejemplar.getEstado() );
            statement.setInt(2, ejemplar.getIsbn_libro());
            
            statement.executeUpdate();
            
            ResultSet rSet = statement.getGeneratedKeys();
            
            if(rSet.next()){
                ejemplar.setId_ejemplar(rSet.getInt(1));
                JOptionPane.showMessageDialog(null,"Ejemplar guardada correctamente.");
            } else {
                JOptionPane.showMessageDialog(null,"No se guardo.");
            }
            
            statement.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al guardar el Ejemplar.");
        }
    }
    
    public void actualizarEjemplar(Ejemplar ejemplar){
    
                 String query = "UPDATE Ejemplar SET estado =?  WHERE id_ejemplar=?   ";

        try {
            PreparedStatement ps=conexion.prepareStatement(query);
           
            ps.setString(1,ejemplar.getEstado() );
            ps.setInt(2, ejemplar.getId_ejemplar());   
                   
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"El Ejemplar ingresado se actualizo");
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"El Ejemplar ingresado no se pudo actualizar");
        }  
    
    }
    
    public void eliminarEjemplar(int id_ejemplar){
    
        String query = "DELETE FROM ejemplar WHERE id_ejemplar=?  ";

        try {
            PreparedStatement ps=conexion.prepareStatement(query);
           
            ps.setInt(1,id_ejemplar);          
           
            if(ps.executeUpdate()==1){
                JOptionPane.showMessageDialog(null, "Se Elimino el Ejemplar con Exito");
            }else{
                JOptionPane.showMessageDialog(null, "No Se Elimino el Ejemplar");
            }
            
            ps.close();
        } catch (SQLException ex ) {
            JOptionPane.showMessageDialog(null,"No se pudo eliminar el Ejemplar."+ex.getMessage());
        }  
    
    
    }
    
   public Ejemplar buscarEjemplar(int id_ejemplar){
   
          String query="select * from ejemplar where id_ejemplar=?";
        Ejemplar ejemplar= null;
        try {
            PreparedStatement ps = conexion.prepareStatement(query); 
                ps.setInt(1,id_ejemplar);
                ResultSet rs=ps.executeQuery();
                if(rs.next()){
                    ejemplar = new Ejemplar();
                    ejemplar.setId_ejemplar(id_ejemplar);
                    ejemplar.setEstado(rs.getString("estado"));
                    ejemplar.setIsbn_libro(rs.getInt("isbn_libro"));
                }else{
                JOptionPane.showMessageDialog(null,"Ejemplar no encontrado.");

                }
                ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar Ejemplar.");
        }
        
        return ejemplar;
       
   } 
      
   public ArrayList<Ejemplar> buscarEjemplarXIsbn(int isbn){
        String query="select * from ejemplar where isbn_libro=?";
       ArrayList< Ejemplar> ejemplar =new ArrayList<>();
        try {
            PreparedStatement ps = conexion.prepareStatement(query); 
                ps.setInt(1,isbn);
                ResultSet rs=ps.executeQuery();
                while(rs.next()){
                   Ejemplar ej = new Ejemplar();
                    ej.setId_ejemplar(rs.getInt("id_ejemplar"));
                    ej.setEstado(rs.getString("estado"));
                    ej.setIsbn_libro(isbn);
                    ejemplar.add(ej);
                }
                

                
                ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar Ejemplar.");
        }
        
        return ejemplar;
   }
    
    
    
}

