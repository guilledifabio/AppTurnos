package com.example.guillermo.appturnos.turnoslist.ui;

import com.example.guillermo.appturnos.turnoslist.entities.Turno;

/**
 * Created by Guillermo on 29/09/2016.
 */

public interface TurnosListView {
    void onReservaAdded(Turno turno);
    void onReservaCancel(Turno turno);
}
