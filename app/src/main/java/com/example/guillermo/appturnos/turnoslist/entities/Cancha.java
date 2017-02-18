package com.example.guillermo.appturnos.turnoslist.entities;

import java.util.Map;

/**
 * Created by Guillermo on 29/09/2016.
 */

public class Cancha {

    Long capacidad;
    Long costo;
    String idcomplejo;
    String nombre;
    String tipo;
    //String hora, Boolean Reservado
    // Map<String, Boolean> turnos;


    public Cancha() {
    }

    public Cancha(String nombre, Long capacidad, Long costo, String complejoid, String tipo) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.costo = costo;
        this.idcomplejo = complejoid;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Long capacidad) {
        this.capacidad = capacidad;
    }

    public Long getCosto() {
        return costo;
    }

    public void setCosto(Long costo) {
        this.costo = costo;
    }

    public String getComplejoid() {
        return idcomplejo;
    }

    public void setComplejoid(String complejoid) {
        this.idcomplejo = complejoid;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
