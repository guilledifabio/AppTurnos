package com.example.guillermo.appturnos.login;

/**
 * Created by ykro.
 */
public interface LoginRepository {
    void signUp(final String nombre, final String apellido, final String telefono, final String email, final String password);
    void signIn(final String nombre, final String apellido, final String telefono, final String email, final String password);
    void checkAlreadyAuthenticated();
}
