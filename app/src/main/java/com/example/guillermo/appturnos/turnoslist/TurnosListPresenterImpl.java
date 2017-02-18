package com.example.guillermo.appturnos.turnoslist;

import android.util.Log;

import com.example.guillermo.appturnos.lib.EventBus;
import com.example.guillermo.appturnos.lib.GreenRobotEventBus;
import com.example.guillermo.appturnos.login.entities.User;
import com.example.guillermo.appturnos.turno.entities.Turno;
import com.example.guillermo.appturnos.turno.ui.TurnoFragment;
import com.example.guillermo.appturnos.turnoslist.events.HorariosListEvent;
import com.example.guillermo.appturnos.turnoslist.events.TurnosListEvent;
import com.example.guillermo.appturnos.turnoslist.ui.TurnosListView;

import org.greenrobot.eventbus.Subscribe;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Guillermo on 29/09/2016.
 */

public class TurnosListPresenterImpl implements TurnosListPresenter {
    EventBus eventBus;
    TurnosListView turnosListView;
    TurnosListInteractor turnosListInteractor;
    TurnosListSessionInteractor turnosListSessionInteractor;


    public TurnosListPresenterImpl(TurnosListView turnosListView) {
        this.eventBus = GreenRobotEventBus.getInstance();
        this.turnosListView = turnosListView;
        this.turnosListInteractor = new TurnosListInteractorImpl();
        this.turnosListSessionInteractor = new TurnosListSessionInteractorImpl();
        this.turnosListInteractor.subscribeForHorariosUpdates("");

    }

    @Override
    public void onPause() {
        turnosListSessionInteractor.changeConnectionStatus(User.OFFLINE);

    }

    @Override
    public void onResume() {
        turnosListInteractor.subscribeForTurnosListUpdates();
        turnosListSessionInteractor.changeConnectionStatus(User.ONLINE);

    }

    @Override
    public void onCreate() {
        eventBus.register(this);

    }

    @Override
    public void onDestroy() {
        eventBus.unregister(this);

        turnosListView = null;

    }

    @Override
    public String getCurrentEmail() {
        return turnosListInteractor.getCurrentEmail();
    }

    @Override
    public void singOff() {
        turnosListSessionInteractor.changeConnectionStatus(User.OFFLINE);
        turnosListInteractor.destroyTurnosListListener();
        turnosListInteractor.unSubscribeForTrunosEvents();

        turnosListSessionInteractor.singOff();
    }

    @Override
    public void obtenerTurnosDisp(String dia) {
        turnosListInteractor.subscribeForHorariosUpdates("");
    }


    @Override
    public String[] obtenerDias() {
        return turnosListInteractor.obtenerDias();
    }

    @Override
    public String getCurrentUserEmail() {
        return turnosListInteractor.getCurrentEmail();
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
    @Subscribe
    public void onEventMainThread(TurnosListEvent event) {
        Turno turno = event.getTurno();

        switch (event.getEventType()) {
            case TurnosListEvent.onTurnoAdded:
                onContactAdded(turno);
                break;
            case TurnosListEvent.onTurnoChanged:
                onContactChanged(turno);
                break;
            case TurnosListEvent.onTurnoRemoved:
                onContactRemoved(turno);
                break;
        }
    }

    @Subscribe
    public void onEventMainThread(HorariosListEvent event) {
        HashMap<String, List<String>> canchasdisp = event.getCanchasdisp();

        switch (event.getEventType()) {
            case HorariosListEvent.onHorarioAdded:
                onHorarioAdded(canchasdisp);
                break;
            case HorariosListEvent.onHorarioChanged:
                onHorarioChanged(canchasdisp);
                break;
            case HorariosListEvent.onHorarioRemoved:
                onHorarioRemoved(canchasdisp);
                break;
        }
    }

    private void onHorarioRemoved(HashMap<String, List<String>> canchasdisp) {
        if (turnosListView != null) {

        }
    }

    private void onHorarioChanged(HashMap<String, List<String>> canchasdisp) {
    }


    private void onHorarioAdded(HashMap<String, List<String>> canchasdisp) {
        if (turnosListView != null) {

        }

    }


    public void onContactAdded(Turno turno) {
        if (turnosListView != null) {
            //Log.d("TurnosListEvent",turno.getFecha());
            //    turnosListView.onContactAdded(user);
        }
    }

    public void onContactChanged(Turno user) {
        if (turnosListView != null) {
            //  turnosListView.onContactChanged(user);
        }
    }

    public void onContactRemoved(Turno user) {
        if (turnosListView != null) {
            // turnosListView.(user);
        }
    }
}
