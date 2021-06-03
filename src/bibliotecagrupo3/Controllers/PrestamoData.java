/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecagrupo3.Controllers;

import bibliotecagrupo3.Models.Lector;
import bibliotecagrupo3.Models.Prestamo;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 *  Rodrigo
 */
public class PrestamoData {
    private Conexion conexion ;

    public PrestamoData(Conexion conexion) throws SQLException {
        this.conexion = conexion.getConexion();
    }
    
    public void guardarPrestamo(Prestamo prestamo){
        
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
