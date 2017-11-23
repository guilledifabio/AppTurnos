package com.example.guillermo.appturnos.turnoslist;

import android.util.Log;

import com.example.guillermo.appturnos.domain.FirebaseHelper;
import com.example.guillermo.appturnos.lib.EventBus;
import com.example.guillermo.appturnos.lib.GreenRobotEventBus;
import com.example.guillermo.appturnos.turno.entities.Turno;

import com.example.guillermo.appturnos.turnoslist.entities.Cancha;
import com.example.guillermo.appturnos.turnoslist.events.CanchaEvent;
import com.example.guillermo.appturnos.turnoslist.events.HorariosListEvent;
import com.example.guillermo.appturnos.turnoslist.events.TurnosListEvent;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Guillermo on 29/09/2016.
 */

public class TurnosListRepositoryImpl implements TurnosListRepository {
    private FirebaseHelper helper;


    private ChildEventListener turnosListEventListener;
    private ChildEventListener horariosEventListener;
    private ValueEventListener canchasEventListener;


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

    @Override
    public void destroyTurnosListListener() {
        turnosListEventListener = null;
    }

    @Override
    public void unSubscribeForContactListUpdates() {
        if (turnosListEventListener != null) {
            helper.getMyContactsReference().removeEventListener(turnosListEventListener);
        }
    }

    @Override
    public void subscribeForTurnosListUpdates() {
        if (turnosListEventListener == null) {
            turnosListEventListener = new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String previousChildKey) {
                    Log.d("TurnosListEvent", dataSnapshot.getKey());


                    Turno turno = dataSnapshot.getValue(Turno.class);
                    Log.d("Fecha", turno.getFecha());
                    Log.d("Cancha", turno.getIdcancha());
                    postEvent(TurnosListEvent.onTurnoAdded, turno);
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String previousChildKey) {
                    Turno turno = dataSnapshot.getValue(Turno.class);
                    postEvent(TurnosListEvent.onTurnoAdded, turno);
                    postEvent(TurnosListEvent.onTurnoChanged, turno);

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                    Turno turno = dataSnapshot.getValue(Turno.class);

                    postEvent(TurnosListEvent.onTurnoAdded, turno);
                    postEvent(TurnosListEvent.onTurnoRemoved, turno);

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }


            };
        }

        helper.getTurnosReference("10/10/2016").addChildEventListener(turnosListEventListener);

    }

    @Override
    public void subscribeForHorariosUpdates(String dia) {

        if (horariosEventListener == null) {
            horariosEventListener = new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String previousChildKey) {
                    Log.d("HorariosEvent", dataSnapshot.getKey()); //con este id tendria que traer la CANCHA
                    HashMap<String, List<String>> canchasdisp = new HashMap<>();
                    List valores = new ArrayList();
                   // HashMap<String, String> horarios = new HashMap<>();
                    HashMap<String ,HashMap<String, String>> horarios = new HashMap<>(); //ver que me conviene mas

                    horarios = (HashMap<String ,HashMap<String, String>>) dataSnapshot.getValue();
                    if (horarios != null) {
                        Log.d("horario", String.valueOf(horarios.toString()));
                     /*   for (String key : horarios.get(dataSnapshot.getKey()).keySet()) {
                            valores.add(horarios.get(key));
                            Log.d("value", String.valueOf(horarios.get(key)));

                        }*/
                        canchasdisp.put(dataSnapshot.getKey(), valores);
                        Log.d("Horarios Disponibles", String.valueOf(canchasdisp.toString()));
                    }
                    postEvent(HorariosListEvent.onHorarioAdded, canchasdisp);
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String previousChildKey) {
                    Log.d("HorariosEvent", dataSnapshot.getKey());
                    //  boolean online = ((Boolean) dataSnapshot.getValue()).booleanValue();
                    //postEvent(TurnosListEvent.onTurnoAdded, turno);
                    //postEvent(TurnosListEvent.onTurnoChanged, turno);

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                    Log.d("HorariosEvent", dataSnapshot.getKey());

                    //   postEvent(TurnosListEvent.onTurnoAdded, turno);
                    // postEvent(TurnosListEvent.onTurnoRemoved, turno);

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }


            };
        }

        helper.getHorariosReference(dia).addChildEventListener(horariosEventListener);


    }

    @Override
    public void getCanchaById(String idcancha) {

        if (canchasEventListener == null) {
            canchasEventListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Get user value
                    Log.d("Key Cancha", dataSnapshot.getKey());
                    Cancha cancha = dataSnapshot.getValue(Cancha.class);
                    Log.d("Nombre de Cancha", cancha.getNombre());
                    Log.d("Capacidad", cancha.getCapacidad().toString());
                    CanchaEvent canchaEvent = new CanchaEvent(cancha);
                    EventBus eventBus = GreenRobotEventBus.getInstance();
                    eventBus.post(canchaEvent);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.d("Cancha", databaseError.toString());
                    // ...
                }
            };
        }

        helper.getCanchaReference(idcancha).addListenerForSingleValueEvent(canchasEventListener);


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

    @Override
    public void changeUserConnectionStatus(boolean online) {
        helper.changeUserConnectionStatus(online);
    }

    private void postEvent(int type, Turno turno) {
        TurnosListEvent turnosListEvent = new TurnosListEvent();
        turnosListEvent.setEventType(type);
        turnosListEvent.setTurno(turno);
        EventBus eventBus = GreenRobotEventBus.getInstance();
        eventBus.post(turnosListEvent);
    }

    private void postEvent(int type, HashMap<String, List<String>> canchasdisp) {
        HorariosListEvent horariosListEvent = new HorariosListEvent();
        horariosListEvent.setEventType(type);
        horariosListEvent.setCanchasdisp(canchasdisp);
        EventBus eventBus = GreenRobotEventBus.getInstance();
        eventBus.post(horariosListEvent);
    }

}
