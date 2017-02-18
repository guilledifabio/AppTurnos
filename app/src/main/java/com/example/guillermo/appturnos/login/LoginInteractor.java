package com.example.guillermo.appturnos.login;

/**
 * Created by ykro.
 */
public interface LoginInteractor {
    void checkAlreadyAuthenticated();

    void doSignUp(String nombre, String apellido, String telefono, String email, String password);

    void doSignIn(String email, String password);
}
