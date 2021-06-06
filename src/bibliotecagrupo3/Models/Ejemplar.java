/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecagrupo3.Models;

/**
 *
 * Pablo
 */
public class Ejemplar {
    private int id_ejemplar;
    private String estado;
    private int isbn_libro;

    public Ejemplar(int id_ejemplar, String estado, int isbn_libro) {
        this.id_ejemplar = id_ejemplar;
        this.estado = estado;
        this.isbn_libro = isbn_libro;
    }

    public Ejemplar(String estado, int isbn_libro) {
        this.estado = estado;
        this.isbn_libro = isbn_libro;
    }

    public Ejemplar() {
        
    }

    public int getId_ejemplar() {
        return id_ejemplar;
    }

    public void setId_ejemplar(int id_ejemplar) {
        this.id_ejemplar = id_ejemplar;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIsbn_libro() {
        return isbn_libro;
    }

    public void setIsbn_libro(int isbn_libro) {
        this.isbn_libro = isbn_libro;
    }

    @Override
    public String toString(){ 
    
        return ("Id_Ejemplar: "+id_ejemplar+" "+"Estado: "+estado+" Isbn_libro "+isbn_libro);
    }
}

