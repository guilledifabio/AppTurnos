package com.example.guillermo.appturnos.turnoslist;

import com.example.guillermo.appturnos.turnoslist.entities.Turno;
import com.example.guillermo.appturnos.turnoslist.events.TurnosListEvent;
import com.example.guillermo.appturnos.turnoslist.ui.TurnosListView;

/**
 * Created by Guillermo on 29/09/2016.
 */

public class TurnosListPresenterImpl implements TurnosListPresenter {
    TurnosListView turnosListView;
    TurnosListInteractor turnosListInteractor;


    public TurnosListPresenterImpl(TurnosListView turnosListView) {
        this.turnosListView = turnosListView;
        this.turnosListInteractor = new TurnosListInteractorImpl();

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {
        turnosListView = null;

    }

    @Override
    public void singOff() {
        turnosListInteractor.singOff();
    }

    @Override
    public String[] obtenerDias() {
        return turnosListInteractor.obtenerDias();
    }

    @Override
    public String getCurrentUserEmail() {
        return null;
    }

    @Override
    public void reservarTruno(String id) {
        turnosListInteractor.reservarTurno(id);
    }

    @Override
    public void cancelarReserva(String id) {
        turnosListInteractor.cancelarReserva(id);
    }

    @Override
    public void onEvnentMainThread(TurnosListEvent turnosListEvent) {

    }
}
