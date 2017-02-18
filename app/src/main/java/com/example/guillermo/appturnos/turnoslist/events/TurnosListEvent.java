package com.example.guillermo.appturnos.turnoslist.events;


import com.example.guillermo.appturnos.turno.entities.Turno;
import com.example.guillermo.appturnos.turnoslist.entities.Complejo;


public class TurnosListEvent {
    private Turno turno;
    private Complejo complejo;
    private int eventType;

    public final static int onTurnoAdded = 0;
    public final static int onTurnoChanged = 1;
    public final static int onTurnoRemoved = 2;

    public Complejo getComplejo() {
        return complejo;
    }

    public void setComplejo(Complejo complejo) {
        this.complejo = complejo;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }
}
