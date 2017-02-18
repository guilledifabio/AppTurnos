package com.example.guillermo.appturnos.turno;

import com.example.guillermo.appturnos.turno.entities.Turno;

import java.util.List;

/**
 * Created by Guillermo on 02/10/2016.
 */

public interface TurnoRespository {
    void cancelReserva(Turno turno);

    void realizarReserva(Turno turno);

    void destroyTurnosListener();

    void subscribeForTurnosUpdates();

    void unSubscribeForTurnosUpdates();

    List<Turno> traerTurnos();
}
