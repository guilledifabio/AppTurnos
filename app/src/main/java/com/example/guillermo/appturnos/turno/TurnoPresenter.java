package com.example.guillermo.appturnos.turno;

import com.example.guillermo.appturnos.turno.entities.Turno;
import com.example.guillermo.appturnos.turno.events.TurnoEvent;

import java.util.List;

/**
 * Created by Guillermo on 02/10/2016.
 */

public interface TurnoPresenter {
    void onPause();

    void onResume();

    void onCreate();

    void onDestroy();


    void cancelReserva(Turno turno);

    void realizarReserva(Turno turno);

    void onEventMainThread(TurnoEvent event);



    List<Turno> traerTurnos();

}
