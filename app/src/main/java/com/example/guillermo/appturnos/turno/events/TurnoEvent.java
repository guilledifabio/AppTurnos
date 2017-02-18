package com.example.guillermo.appturnos.turno.events;

import com.example.guillermo.appturnos.turno.entities.Turno;

/**
 * Created by Guillermo on 02/10/2016.
 */

public class TurnoEvent {
    private Turno turno;
    private int eventType;

    public final static int onReservaRealizada = 0;
    public final static int onReservaCancelada = 1;


    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }
}
