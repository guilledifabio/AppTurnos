package com.example.guillermo.appturnos.turnoslist;

import android.util.Log;

import com.example.guillermo.appturnos.domain.FirebaseHelper;
import com.example.guillermo.appturnos.turnoslist.entities.Turno;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by Guillermo on 29/09/2016.
 */

public class TurnosListRepositoryImpl implements TurnosListRepository {
    private FirebaseHelper helper;

    public TurnosListRepositoryImpl() {
        this.helper = FirebaseHelper.getInstance();
    }

    @Override
    public void signOff() {
        helper.signOff();
    }

    @Override
    public String getCurrentEmail() {

        return helper.getAuthUserEmail();
    }

    @Override
    public String[] obtenerDias() {

        Calendar now = new GregorianCalendar();

        String[] dias = new String[10];
        for (int i = 0; i < 10; i++) {
            if (i != 0)
                now.add(Calendar.DAY_OF_YEAR, 1);
            dias[i] = String.valueOf(convertirdia(now.get(Calendar.DAY_OF_WEEK))) + " " + String.valueOf(now.get(Calendar.DATE)) + "/" + String.valueOf(now.get(Calendar.MONTH) + 1);
            Log.d("Pasado", String.valueOf(convertirdia(now.get(Calendar.DAY_OF_WEEK))) + " " + String.valueOf(now.get(Calendar.DATE)) + "/" + String.valueOf(now.get(Calendar.MONTH) + 1));

        }
        return dias;
    }

    @Override
    public void reservarTurno(String id) {

    }

    @Override
    public void cancelarReserva(String id) {

    }

    private String convertirdia(int dia) {
        String diaconv = "";
        switch (dia) {
            case 1:
                diaconv = "Domingo";
                break;
            case 2:
                diaconv = "Lunes";
                break;
            case 3:
                diaconv = "Martes";
                break;
            case 4:
                diaconv = "Miercoles";
                break;
            case 5:
                diaconv = "Jueves";
                break;
            case 6:
                diaconv = "Viernes";
                break;
            case 7:
                diaconv = "Sabado";

                break;

        }
        return diaconv;
    }
}
