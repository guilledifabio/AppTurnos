package com.example.guillermo.appturnos.turnoslist;

/**
 * Created by ykro.
 */
public interface TurnosListSessionInteractor {
    void singOff();

    void changeConnectionStatus(boolean online);

    String getCurrentUserEmail();

}
