/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecagrupo3.Controllers;

import bibliotecagrupo3.Models.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import bibliotecaGrupo3.Controllers.Conexion;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Nahuel
 */
public class LibroData {

    private Connection con;

    public LibroData(Conexion conexion) throws SQLException {
        this.con = conexion.getConexion();
    }

    public void guardarLibro(Libro libro) {
        try {
            String query = "INSERT INTO libro (id_autor, nombre, editorial, año, tipo, isbn) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, libro.getId_autor());
            ps.setString(2, libro.getNombre());
            ps.setString(3, libro.getEditorial());
            ps.setInt(4, libro.getAño());
            ps.setString(5, libro.getTipo());
            ps.setInt(6, libro.getIsbn());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                libro.setId_libro(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Libro guardado");
            } else {
                JOptionPane.showMessageDialog(null, "Libro no guardado");
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error SQL");
        }
    }
    public Libro buscarLibro(int isbn) {
        String query = "SELECT * FROM libro WHERE libro.isbn = ?";
        Libro libro = null;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, isbn);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                libro = new Libro();
                libro.setNombre(rs.getString("nombre"));
                libro.setEditorial(rs.getString("editorial"));
                libro.setAño(rs.getInt("año"));
                libro.setTipo(rs.getString("tipo"));
                libro.setIsbn(rs.getInt("isbn"));
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error SQL");
        }
        return libro;
    }

    

    public void modificarLibro(Libro libro) {
        try {
            String query = "UPDATE libro SET id_autor=?, nombre=?, editorial=?, año=?, tipo=? WHERE isbn=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, libro.getId_autor());
            ps.setString(2, libro.getNombre());
            ps.setString(3, libro.getEditorial());
            ps.setInt(4, libro.getAño());
            ps.setString(5, libro.getTipo());
            ps.setInt(6, libro.getIsbn());
            ps.executeUpdate();
            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Libro Modificado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar el Libro");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error SQL");
        }
    }

    public void borrarLibro(int isbn) {
        try {
            String query = "DELETE FROM libro WHERE isbn=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, isbn);
            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Libro borrado");
            } else {
                JOptionPane.showMessageDialog(null, "Libro no borrado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error SQL");
        }
    }
    
    public List<Libro> getAllLibros() {
        String query = "SELECT * FROM libro";
        Libro libro;
        List<Libro> libros = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                libro = new Libro();
                libro.setNombre(rs.getString("nombre"));
                libro.setEditorial(rs.getString("editorial"));
                libro.setAño(rs.getInt("año"));
                libro.setTipo(rs.getString("tipo"));
                libro.setIsbn(rs.getInt("isbn"));
                libros.add(libro);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error SQL");
        }
        return libros;
    }

}
