/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecagrupo3.Models;

import java.time.LocalDate;

/**
 *
 * Pablo
 */
public class Multa {
    private int id_multa;
    
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;

    public Multa(int id_multa, LocalDate fecha_inicio, LocalDate fecha_fin) {
        this.id_multa = id_multa;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public Multa() {
    }


    public Multa(LocalDate fecha_inicio, LocalDate fecha_fin) {
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

   
  
   

    public int getId_multa() {
        return id_multa;
    }

    public void setId_multa(int id_multa) {
        this.id_multa = id_multa;
    }
     
    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
    
   @Override
    public String toString(){
    return ("Id_Multa: "+id_multa+" "+"Fecha de inicio: "+fecha_inicio+" "+"Fecha de fin: "+fecha_fin);
    }
}
