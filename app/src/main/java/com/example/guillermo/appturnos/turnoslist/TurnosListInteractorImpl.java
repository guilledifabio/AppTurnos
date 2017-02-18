package com.example.guillermo.appturnos.turnoslist;

/**
 * Created by Guillermo on 29/09/2016.
 */

public class TurnosListInteractorImpl implements TurnosListInteractor {
    TurnosListRepository turnosListRepository;

    public TurnosListInteractorImpl() {
        turnosListRepository = new TurnosListRepositoryImpl();
    }

    @Override
    public void reservarTurno(String id) {
        turnosListRepository.reservarTurno(id);
    }


    @Override
    public String[] obtenerDias() {
        return turnosListRepository.obtenerDias();
    }

    @Override
    public void cancelarReserva(String id) {
        turnosListRepository.cancelarReserva(id);
    }

    @Override
    public String getCurrentEmail() {
        return turnosListRepository.getCurrentEmail();
    }

    @Override
    public void destroyTurnosListListener() {
        turnosListRepository.destroyTurnosListListener();
    }

    @Override
    public void subscribeForTurnosListUpdates() {
        turnosListRepository.subscribeForTurnosListUpdates();
    }

    @Override
    public void subscribeForHorariosUpdates(String dia) {
        turnosListRepository.subscribeForHorariosUpdates(dia);
    }

    @Override
    public void getCanchaById(String idcancha) {
        turnosListRepository.getCanchaById(idcancha);
    }

    @Override
    public void unSubscribeForTrunosEvents() {
        turnosListRepository.unSubscribeForContactListUpdates();

    }
}
