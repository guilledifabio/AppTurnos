package com.example.guillermo.appturnos.turnoslist;

import com.example.guillermo.appturnos.turnoslist.entities.Turno;

/**
 * Created by Guillermo on 29/09/2016.
 */

public interface TurnosListInteractor {
    void reservarTurno(String id);

    void singOff();

    String[] obtenerDias();

    void cancelarReserva(String id);
}
