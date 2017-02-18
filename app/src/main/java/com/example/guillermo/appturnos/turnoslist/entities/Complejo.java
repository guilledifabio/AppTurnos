package com.example.guillermo.appturnos.turnoslist.entities;

import java.util.List;
import java.util.Map;

/**
 * Created by ykro.
 */
public class Complejo {
    String nombre;
    Direccion direccion;
    String logo;
    List<Cancha> canchas;

    public Complejo() {
    }

    public Complejo(String nombre, Direccion direccion, String logo, List<Cancha> canchas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.logo = logo;
        this.canchas = canchas;
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<Cancha> getCanchas() {
        return canchas;
    }

    public void setCanchas(List<Cancha> canchas) {
        this.canchas = canchas;
    }
}
