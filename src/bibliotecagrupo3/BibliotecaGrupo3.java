/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecagrupo3;

import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import bibliotecaGrupo3.Controllers.Conexion;
import bibliotecagrupo3.Controllers.AutorData;
import bibliotecagrupo3.Controllers.LibroData;
import bibliotecagrupo3.Controllers.PrestamoData;
import bibliotecagrupo3.Models.Autor;
import bibliotecagrupo3.Models.Libro;
import bibliotecagrupo3.Models.Prestamo;

/**
 *
 * @author Rodrigo
 */
public class BibliotecaGrupo3 {
    public static void main(String[] args) throws SQLException {
        try {
            Conexion conexion = new Conexion();

            //----PRUEBA AUTOR----
            AutorData ad = new AutorData(conexion);
            Autor nahuel = new Autor(41272923,"Juan","vargas",LocalDate.of(1998, 6, 13),"Uruguay");
            //ad.guardarAutor(nahuel);
            //ad.eliminarAutor(41272923);
            //ad.modificarAutor(nahuel);
            //----PRUEBA LIBRO----
            LibroData ld = new LibroData(conexion);
            Libro libro1 = new Libro(7,"El chapulin colorado","Biblioteca Mexicana",1997,"Comedia",8);
            //ld.guardarLibro(libro1);
            //ld.borrarLibro(10);
            //ld.modificarLibro(libro1);
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
