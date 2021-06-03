/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecagrupo3.Models;

import java.time.LocalDate;

/**
 *
 * Rodrigo
 */
public class Prestamo {
    private int id_prestamo;
    private int id_multa;
    private int id_ejemplar;
    private int dni_lector;
    private boolean estado;
    private LocalDate fecha;
    private LocalDate fecha_devolucion;

    public Prestamo(int id_prestamo, int id_multa, int id_ejemplar, int dni_lector, boolean estado, LocalDate fecha, LocalDate fecha_devolucion) {
        this.id_prestamo = id_prestamo;
        this.id_multa = id_multa;
        this.id_ejemplar = id_ejemplar;
        this.dni_lector = dni_lector;
        this.estado = estado;
        this.fecha = fecha;
        this.fecha_devolucion = fecha_devolucion;
    }
    
    public Prestamo(int id_multa, int id_ejemplar, int dni_lector, boolean estado, LocalDate fecha, LocalDate fecha_devolucion) {
        this.id_multa = id_multa;
        this.id_ejemplar = id_ejemplar;
        this.dni_lector = dni_lector;
        this.estado = estado;
        this.fecha = fecha;
        this.fecha_devolucion = fecha_devolucion;
    }
    
    public Prestamo(){};

    public int getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public int getId_multa() {
        return id_multa;
    }

    public void setId_multa(int id_multa) {
        this.id_multa = id_multa;
    }

    public int getId_ejemplar() {
        return id_ejemplar;
    }

    public void setId_ejemplar(int id_ejemplar) {
        this.id_ejemplar = id_ejemplar;
    }

    public int getDni_lector() {
        return dni_lector;
    }

    public void setDni_lector(int dni_lector) {
        this.dni_lector = dni_lector;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(LocalDate fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "id_prestamo=" + id_prestamo + ", id_ejemplar=" + id_ejemplar + ", dni_lector=" + dni_lector + ", estado=" + estado + '}';
    }
}
