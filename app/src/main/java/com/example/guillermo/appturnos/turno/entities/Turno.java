package com.example.guillermo.appturnos.turno.entities;

/**
 * Created by Guillermo on 29/09/2016.
 */

public class Turno {
    private String fecha;
    private String hora;
    private String fechareser;
    private String horareser;
    private String propietario;
    private String idcancha;
    private Boolean reservado;

    public Turno() {
    }

    public Turno(String fecha, String hora, String fechareser, String horareser, String propietario, String idcancha, Boolean reservado) {
        this.fecha = fecha;
        this.hora = hora;
        this.fechareser = fechareser;
        this.horareser = horareser;
        this.propietario = propietario;
        this.idcancha = idcancha;
        this.reservado = reservado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFechareser() {
        return fechareser;
    }

    public void setFechareser(String fechareser) {
        this.fechareser = fechareser;
    }

    public String getHorareser() {
        return horareser;
    }

    public void setHorareser(String horareser) {
        this.horareser = horareser;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getIdcancha() {
        return idcancha;
    }

    public void setIdcancha(String idcancha) {
        this.idcancha = idcancha;
    }

    public Boolean getReservado() {
        return reservado;
    }

    public void setReservado(Boolean reservado) {
        this.reservado = reservado;
    }
}
