package com.example.guillermo.appturnos.turnoslist.events;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Guillermo on 17/10/2016.
 */

public class HorariosListEvent {
    private HashMap<String, List<String>> canchasdisp;
    private int eventType;

    public final static int onHorarioAdded = 0;
    public final static int onHorarioChanged = 1;
    public final static int onHorarioRemoved = 2;

    public HashMap<String, List<String>> getCanchasdisp() {
        return canchasdisp;
    }

    public void setCanchasdisp(HashMap<String, List<String>> canchasdisp) {
        this.canchasdisp = canchasdisp;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }
}
