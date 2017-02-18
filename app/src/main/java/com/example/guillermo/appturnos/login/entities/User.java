package com.example.guillermo.appturnos.login.entities;

import java.util.Map;

/**
 * Created by ykro.
 */
public class User {
    String nombre;
    String apellido;
    String telefono;
    String email;
    boolean online;
    Boolean admin;

    public final static boolean ONLINE = true;
    public final static boolean OFFLINE = false;

    public User(){ }

    public User(String nombre, String apellido, String telefono, String email, boolean online, Boolean admin) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.online = online;
        this.admin = admin;
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
        apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public static boolean isONLINE() {
        return ONLINE;
    }

    public static boolean isOFFLINE() {
        return OFFLINE;
    }
}
