package com.example.guillermo.appturnos.turnoslist.events;

import com.example.guillermo.appturnos.turnoslist.entities.Cancha;

/**
 * Created by Guillermo on 17/10/2016.
 */

public class CanchaEvent {
    Cancha cancha;

    public CanchaEvent(Cancha cancha) {
        this.cancha = cancha;
    }

    public Cancha getCancha() {
        return cancha;
    }
}
