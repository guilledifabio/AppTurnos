package com.example.guillermo.appturnos.turnoslist.entities;

/**
 * Created by Guillermo on 29/09/2016.
 */

public class Direccion {
    String descripcion;
    String latitud;
    String longitud;

    public Direccion() {
    }

    public Direccion(String descripcion, String latitud, String longitud) {
        this.descripcion = descripcion;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
}
