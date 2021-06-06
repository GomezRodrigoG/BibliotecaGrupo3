/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecagrupo3;


import static java.time.temporal.TemporalQueries.localDate;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import bibliotecaGrupo3.Controllers.Conexion;
import bibliotecagrupo3.Controllers.AutorData;
import bibliotecagrupo3.Controllers.LibroData;
import bibliotecagrupo3.Controllers.PrestamoData;
import bibliotecagrupo3.Controllers.LectorData;
import bibliotecagrupo3.Models.Lector;
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
                LectorData lectorData = new LectorData(conexion);
//                LocalDate fecha = LocalDate.of(2021, 4, 1);
//                Lector lector = new Lector(11111111, "pringles 1906", "Gillermo", "scheloto", true);
//                lectorData.guardarLector(lector);
//                  Lector lector = lectorData.buscarLector(11111111);
//                  System.out.println(lector);
//                  lectorData.bajaLector(11111111);
//                    lectorData.modificarLector(lector);
//                ArrayList <Lector> lista= lectorData.getConMulta(7);
//                for(Lector caca:lista){
//                    System.out.println(caca);
//                }
            
            // pData.crear(prestamo);
            pData.borrar(5);

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Error al cargar los driver de conexion");
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion");
        }
    }
    
}
