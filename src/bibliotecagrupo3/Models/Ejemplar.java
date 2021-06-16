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
    private Libro libro;

    public Ejemplar(int id_ejemplar, String estado, Libro libro) {
        this.id_ejemplar = id_ejemplar;
        this.estado = estado;
        this.libro = libro;
    }

    public Ejemplar(String estado, Libro libro) {
        this.estado = estado;
        this.libro = libro;
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

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    @Override
    public String toString(){ 
    
        return ("Id_Ejemplar: "+id_ejemplar+" "+"Estado: "+estado+" Isbn_libro "+libro);
    }
}

