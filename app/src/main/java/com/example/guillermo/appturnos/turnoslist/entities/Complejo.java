package com.example.guillermo.appturnos.turnoslist.entities;

import java.util.Map;

/**
 * Created by ykro.
 */
public class Complejo {
    String nombre;
    Direccion direccion;
//String hora, Boolean Reservado
    Map<String, Boolean> turnos;


    public Complejo(){ }

    public Complejo(String nombre, Direccion direccion, Map<String, Boolean> turnos) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.turnos = turnos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Map<String, Boolean> getTurnos() {
        return turnos;
    }

    public void setTurnos(Map<String, Boolean> turnos) {
        this.turnos = turnos;
    }
}
