package com.example.guillermo.appturnos.turnoslist;

import com.example.guillermo.appturnos.turnoslist.entities.Turno;
import com.example.guillermo.appturnos.turnoslist.events.TurnosListEvent;

/**
 * Created by Guillermo on 29/09/2016.
 */

public interface TurnosListPresenter {
    void onPause();

    void onResume();

    void onCreate();

    void onDestroy();

    void singOff();

    String[] obtenerDias();

    String getCurrentUserEmail();

    void reservarTruno(String id);

    void cancelarReserva(String id);

    void onEvnentMainThread(TurnosListEvent turnosListEvent);
}
