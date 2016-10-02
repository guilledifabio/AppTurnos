package com.example.guillermo.appturnos;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;


/**
 * Created by horaciomunoz on 3/7/16.
 */

public class TurnosApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        setupFirebase();

    }

    private void setupFirebase() {
        FirebaseDatabase.getInstance().setPersistenceEnabled(false); //Soporte para caracteristicas online
    }
}