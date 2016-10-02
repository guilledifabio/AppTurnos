package com.example.guillermo.appturnos.turnoslist;

import com.example.guillermo.appturnos.turnoslist.entities.Turno;

/**
 * Created by Guillermo on 29/09/2016.
 */

public interface TurnosListRepository {
    void signOff();

    String getCurrentEmail();

    String[] obtenerDias();

    void reservarTurno(String id);

    void cancelarReserva(String id);
}
