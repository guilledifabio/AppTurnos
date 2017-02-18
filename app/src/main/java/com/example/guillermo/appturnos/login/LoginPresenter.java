package com.example.guillermo.appturnos.login;


import com.example.guillermo.appturnos.login.events.LoginEvent;

/**
 * Created by ykro.
 */
public interface LoginPresenter {
    void onCreate();

    void onDestroy();

    void checkForAuthenticatedUser();

    void onEventMainThread(LoginEvent event);

    void validateLogin(String email, String password);

    void registerNewUser(String nombre, String apellido, String telefono, String email, String password);
}
