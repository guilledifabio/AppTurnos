package com.example.guillermo.appturnos.login;

/**
 * Created by ykro.
 */

public class LoginInteractorImpl implements LoginInteractor {
    private LoginRepository loginRepository;

    public LoginInteractorImpl() {
        this.loginRepository = new LoginRepositoryImpl();
    }

    @Override
    public void doSignUp(String nombre,String apellido,String telefono,String email, String password) {
        loginRepository.signUp( nombre, apellido, telefono, email, password);
    }

    @Override
    public void doSignIn(String email, String password) {
        loginRepository.signIn(null,null,null,email, password);
    }

    @Override
    public void checkAlreadyAuthenticated() {
        loginRepository.checkAlreadyAuthenticated();
    }
}
