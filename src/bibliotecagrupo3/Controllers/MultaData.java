/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecagrupo3.Controllers;

import bibliotecagrupo3.Models.Multa;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import bibliotecaGrupo3.Controllers.Conexion;
/**
 *
 * Pablo
 */
public class MultaData {
     private Connection  conexion ;

    public MultaData(Conexion conexion) throws SQLException {
        this.conexion = conexion.getConexion();
    
    }
    
    public int guardarMulta(int libros){
        String query = "INSERT INTO multa VALUE (null,?,?)";
        int id=0;
         
        try {
            PreparedStatement statement = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            int dias = (libros*2);
         
            statement.setDate(1,Date.valueOf(LocalDate.now()));
            //Suma los dias de multa para agregarlos a la fecha final
            statement.setDate(2,Date.valueOf(LocalDate.now().plusDays(dias)));
            
         
            statement.executeUpdate();
            
            ResultSet rSet = statement.getGeneratedKeys();
            
            if(rSet.next()){
                 id= rSet.getInt(1);
                JOptionPane.showMessageDialog(null,"La Multa se  guardo correctamente.");
                
                
            } else {
                JOptionPane.showMessageDialog(null,"La Multa No se pudo guardar.");
               
            }
            
            statement.close();
           
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al guardar la Multa.");
        }
          return id;
    }  
  
    public Multa buscarMulta(int id_Multa){
        String query="select * from Multa where id_multa=?";
        Multa multa= null;
        try {
            PreparedStatement ps = conexion.prepareStatement(query); 
                ps.setInt(1,id_Multa);
                ResultSet rs=ps.executeQuery();
                if(rs.next()){
                    multa=new Multa();
                    multa.setId_multa(id_Multa);
                    multa.setFecha_inicio(rs.getDate("fecha_inicio").toLocalDate());
                    multa.setFecha_fin(rs.getDate("fecha_fin").toLocalDate());
                }else{
                    JOptionPane.showMessageDialog(null,"Multa no encontrada.");
                    
                }
                    
                ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al Buscar La Multa");;
        }
        
        return multa;
        
    }
    
     public void eliminarMulta(int id_multa){
    
        String query = "DELETE FROM multa WHERE id_multa = ?  ";

        try {
            PreparedStatement ps=conexion.prepareStatement(query);
           
            ps.setInt(1,id_multa);          
           
            if(ps.executeUpdate()==1){
                JOptionPane.showMessageDialog(null, "Se Elimino la Multa con Exito");
            }else{
                JOptionPane.showMessageDialog(null, "No Se pudo Eliminar La Multa");
            }
            
            ps.close();
        } catch (SQLException ex ) {
            JOptionPane.showMessageDialog(null,"No se pudo eliminar el alumno."+ex.getMessage());
        }  
    
    }
     
    public void modificarMulta(Multa multa){
    
        String query = "UPDATE multa SET fecha_inicio=?,fecha_fin=? WHERE id_multa = ?  ";

        try {
            PreparedStatement ps=conexion.prepareStatement(query);
           
            ps.setDate(1, Date.valueOf(multa.getFecha_inicio()));
            ps.setDate(2, Date.valueOf(multa.getFecha_fin()));    
            ps.setInt(3, multa.getId_multa());
            
           
           
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"La Multa ingresada se actualizo");
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"La Multa ingresada no se pudo actualizar");
        }  
    
    } 
    
}  
        

