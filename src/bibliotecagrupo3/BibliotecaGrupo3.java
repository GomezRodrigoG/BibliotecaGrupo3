/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecagrupo3;

import bibliotecaGrupo3.Controllers.Conexion;
import bibliotecagrupo3.Controllers.PrestamoData;
import bibliotecagrupo3.Models.Prestamo;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class BibliotecaGrupo3 {
    public static void main(String[] args) {
        try {
            Conexion conexion = new Conexion();
            
            // ---- Pruebas de prestamo ----
            PrestamoData pData = new PrestamoData(conexion);
            
            Prestamo prestamo = new Prestamo();
            
            // pData.crear(prestamo);
            pData.borrar(5);
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Error al cargar los driver de conexion");
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion");
        }
    }
    
}
