/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecagrupo3;

import bibliotecaGrupo3.Controllers.Conexion;
import bibliotecagrupo3.Controllers.LectorData;
import bibliotecagrupo3.Models.Lector;
import java.sql.SQLException;
import java.time.LocalDate;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class BibliotecaGrupo3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Conexion conexion = new Conexion();
            
            try {
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
            } catch (SQLException ex) {
                Logger.getLogger(BibliotecaGrupo3.class.getName()).log(Level.SEVERE, null, ex);
            }
            
//            JOptionPane.showMessageDialog(null,"Se cargo correctamente");
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Error al cargar los driver de conexion");
        }
    }
    
}
