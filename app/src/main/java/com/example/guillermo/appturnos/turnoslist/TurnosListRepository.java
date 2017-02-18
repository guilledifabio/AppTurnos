package com.example.guillermo.appturnos.turnoslist;

/**
 * Created by Guillermo on 29/09/2016.
 */

public interface TurnosListRepository {
    void signOff();

    String getCurrentEmail();

    String[] obtenerDias();

    void reservarTurno(String id);

    void cancelarReserva(String id);

    void destroyTurnosListListener();

    void unSubscribeForContactListUpdates();

    void subscribeForTurnosListUpdates();

    void subscribeForHorariosUpdates(String dia);

    void getCanchaById(String idcancha);

    void changeUserConnectionStatus(boolean online);
}
