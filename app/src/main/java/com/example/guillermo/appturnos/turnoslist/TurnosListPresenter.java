package com.example.guillermo.appturnos.turnoslist;

import com.example.guillermo.appturnos.turnoslist.events.TurnosListEvent;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Guillermo on 29/09/2016.
 */

public interface TurnosListPresenter {
    void onPause();

    void onResume();

    void onCreate();

    void onDestroy();

    String getCurrentEmail();

    void singOff();

    void obtenerTurnosDisp(String dia);

    String[] obtenerDias();

    String getCurrentUserEmail();

    void reservarTruno(String id);

    void cancelarReserva(String id);

    void onEventMainThread(TurnosListEvent turnosListEvent);

}
