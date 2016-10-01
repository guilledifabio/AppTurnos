package com.example.guillermo.appturnos.turnoslist;

/**
 * Created by ykro.
 */
public class TurnosListSessionInteractorImpl implements TurnosListSessionInteractor {
    TurnosListRepository turnosListRepository;

    public TurnosListSessionInteractorImpl() {
        this.turnosListRepository = new TurnosListRepositoryImpl();
    }

    @Override
    public void signOff() {
        turnosListRepository.signOff();
    }

    @Override
    public String getCurrentUserEmail() {
        return turnosListRepository.getCurrentEmail();
    }


}
