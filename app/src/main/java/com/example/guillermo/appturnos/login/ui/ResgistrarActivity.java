package com.example.guillermo.appturnos.login.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.example.guillermo.appturnos.R;
import com.example.guillermo.appturnos.login.LoginPresenter;
import com.example.guillermo.appturnos.login.LoginPresenterImpl;
import com.example.guillermo.appturnos.turnoslist.ui.TurnosActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Guillermo on 04/10/2016.
 */

public class ResgistrarActivity extends AppCompatActivity implements LoginView {

    @Bind(R.id.editNombre)
    EditText editNombre;
    @Bind(R.id.editApellido)
    EditText editApellido;
    @Bind(R.id.editTelefono)
    EditText editTelefono;
    @Bind(R.id.editTxtEmail)
    EditText editTxtEmail;
    @Bind(R.id.editTxtPassword)
    EditText editTxtPassword;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @Bind(R.id.btnSignup)
    Button btnSignup;
    @Bind(R.id.layoutMainContainer)
    RelativeLayout container;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        ButterKnife.bind(this);

        loginPresenter = new LoginPresenterImpl(this);
        loginPresenter.onCreate();
        loginPresenter.checkForAuthenticatedUser();

    }
    @Override
    @OnClick(R.id.btnSignup)
    public void handleSignUp() {
        Intent intent = new Intent(this, TurnosActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                | Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
     loginPresenter.registerNewUser(editNombre.getText().toString(),editApellido.getText().toString(),editTelefono.getText().toString(),editTxtEmail.getText().toString(),
                editTxtPassword.getText().toString());

    }

    @Override
    public void enableInputs() {

    }

    @Override
    public void disableInputs() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }



    @Override
    public void handleSignIn() {

    }

    @Override
    public void navigateToMainScreen() {

    }

    @Override
    public void loginError(String error) {

    }

    @Override
    public void newUserSuccess() {
        Snackbar.make(container, R.string.login_notice_message_useradded, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void newUserError(String error) {

    }
}
