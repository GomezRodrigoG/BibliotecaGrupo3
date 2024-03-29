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
    private Multa multa;
    private Ejemplar ejemplar;
    private Lector lector;
    private boolean estado;
    private LocalDate fecha;
    private LocalDate fecha_devolucion;

    public Prestamo(int id_prestamo, Multa multa, Ejemplar ejemplar, Lector lector, boolean estado, LocalDate fecha, LocalDate fecha_devolucion) {
        this.id_prestamo = id_prestamo;
        this.multa = multa;
        this.ejemplar = ejemplar;
        this.lector = lector;
        this.estado = estado;
        this.fecha = fecha;
        this.fecha_devolucion = fecha_devolucion;
    }
    
    // constructor extra, especialmente utilizado para la creacion de un nuevo prestamo
    public Prestamo(Ejemplar ejemplar, Lector lector) {
        this.ejemplar = ejemplar;
        this.lector = lector;
    }
    
    // constructor extra, especialmente utilizado para la modificacion de un prestamo
    public Prestamo(int id_prestamo, Ejemplar ejemplar, Lector lector) {
        this.id_prestamo = id_prestamo;
        this.ejemplar = ejemplar;
        this.lector = lector;
    }
    
    // constructor extra, especialmente utilizado para la devolucion de un prestamo
    public Prestamo(int id_prestamo, LocalDate fecha, LocalDate fecha_devolucion) {
        this.id_prestamo = id_prestamo;
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

    public Multa getMulta() {
        return multa;
    }

    public void setMulta(Multa multa) {
        this.multa = multa;
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
    }

    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
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
        if(this.multa == null){
            return "Prestamo{" + "id_prestamo=" + id_prestamo + ", multa= Sin Multa, ejemplarId=" + ejemplar.getId_ejemplar() + ", lectorDNI=" + lector.getDni() + ", estado=" + estado + ", fecha=" + fecha + ", fecha_devolucion=" + fecha_devolucion + '}';
        }
        
        return "Prestamo{" + "id_prestamo=" + id_prestamo + ", multa=" + multa.getId_multa() + ", ejemplarId=" + ejemplar.getId_ejemplar() + ", lectorDNI=" + lector.getDni() + ", estado=" + estado + ", fecha=" + fecha + ", fecha_devolucion=" + fecha_devolucion + '}';
    }
}
