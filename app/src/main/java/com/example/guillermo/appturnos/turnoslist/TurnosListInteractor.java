package com.example.guillermo.appturnos.turnoslist;

/**
 * Created by Guillermo on 29/09/2016.
 */

public interface TurnosListInteractor {
    void reservarTurno(String id);


    String[] obtenerDias();

    void cancelarReserva(String id);

    String getCurrentEmail();

    void destroyTurnosListListener();

    void subscribeForTurnosListUpdates();

    void subscribeForHorariosUpdates(String dia);

    void getCanchaById(String idcancha);

    void unSubscribeForTrunosEvents();
}
