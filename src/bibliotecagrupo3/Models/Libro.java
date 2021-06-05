/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecagrupo3.Models;

/**
 *
 * Nahuel
 */
public class Libro {
    private int id_libro;
    private int id_autor;
    private String nombre;
    private String editorial;
    private int año;
    private String tipo;
    private int isbn;

    public Libro(int id_autor, String nombre, String editorial, int año, String tipo, int isbn) {
        this.id_autor = id_autor;
        this.nombre = nombre;
        this.editorial = editorial;
        this.año = año;
        this.tipo = tipo;
        this.isbn = isbn;
    }

    
    
    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getId_libro() {
        return id_libro;
    }

    public int getId_autor() {
        return id_autor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEditorial() {
        return editorial;
    }

    public int getAño() {
        return año;
    }

    public String getTipo() {
        return tipo;
    }

    public int getIsbn() {
        return isbn;
    }
    
    
}
