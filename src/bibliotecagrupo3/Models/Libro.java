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
    private Autor autor;
    private String nombre;
    private String editorial;
    private int año;
    private String tipo;
    private int isbn;

    public Libro(int id_libro, Autor autor, String nombre, String editorial, int año, String tipo, int isbn) {
        this.id_libro = id_libro;
        this.autor = autor;
        this.nombre = nombre;
        this.editorial = editorial;
        this.año = año;
        this.tipo = tipo;
        this.isbn = isbn;
    }

    
    public Libro(Autor autor, String nombre, String editorial, int año, String tipo, int isbn) {
        this.autor = autor;
        this.nombre = nombre;
        this.editorial = editorial;
        this.año = año;
        this.tipo = tipo;
        this.isbn = isbn;
    }

    public Libro(String nombre, String editorial, int año, String tipo, int isbn) {
        this.nombre = nombre;
        this.editorial = editorial;
        this.año = año;
        this.tipo = tipo;
        this.isbn = isbn;
    }

    
    public Libro() {
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
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

    @Override
    public String toString() {
        return "\nNombre: " + nombre + "\nEditorial: " + editorial + "\nAño: " + año + "\nTipo: " + tipo
                + "\n--------------------------------\n";
    }

}
