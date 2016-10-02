package com.example.guillermo.appturnos.lib;

/**
 * Created by ykro.
 */
public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);

}
