package com.example.guillermo.appturnos.turnoslist.ui;


import com.example.guillermo.appturnos.turnoslist.entities.Complejo;
import com.example.guillermo.appturnos.turnoslist.entities.Turno;

public interface OnItemClickListener {
    void onItemClick(Turno turno);
    void onItemLongClick(Turno turno);
}
