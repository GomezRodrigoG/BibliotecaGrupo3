/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecagrupo3.Models;

import java.time.LocalDate;

/**
 *
 * Gustavo
 */
public class Lector {
    private int dni;
    private String direccion;
    private String nombre;
    private String apellido;
    private boolean estado;

    public Lector(int dni, String direccion, String nombre, String apellido, boolean estado) {
        this.dni = dni;
        this.direccion = direccion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
    }

    public Lector() {
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return dni+"-"+nombre+"-"+apellido;
    }
    
    
}
