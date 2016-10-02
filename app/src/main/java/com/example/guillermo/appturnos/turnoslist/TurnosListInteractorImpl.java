package com.example.guillermo.appturnos.turnoslist;

import com.example.guillermo.appturnos.turnoslist.entities.Turno;

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
    public void singOff() {
        turnosListRepository.signOff();
    }

    @Override
    public String[] obtenerDias() {
        return turnosListRepository.obtenerDias();
    }

    @Override
    public void cancelarReserva(String id) {
        turnosListRepository.cancelarReserva(id);
    }
}
