package com.example.guillermo.appturnos.login.ui;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.example.guillermo.appturnos.R;
import com.example.guillermo.appturnos.login.LoginPresenter;
import com.example.guillermo.appturnos.login.LoginPresenterImpl;
import com.example.guillermo.appturnos.main.MainActivity;
import com.example.guillermo.appturnos.turnoslist.ui.TurnosActivity;

import butterknife.Bind;


import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginActivity extends AppCompatActivity
        implements LoginView {

    @Bind(R.id.layoutMainContainer)
    RelativeLayout container;
    @Bind(R.id.editTxtEmail)
    EditText editTxtEmail;
    @Bind(R.id.editTxtPassword)
    EditText editTxtPassword;
    @Bind(R.id.btnSignin)
    Button btnSignin;
    @Bind(R.id.btnSignup)
    Button btnSignup;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginPresenter = new LoginPresenterImpl(this);
        loginPresenter.onCreate();
        loginPresenter.checkForAuthenticatedUser();

    }

    @Override
    protected void onDestroy() {
        loginPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    @OnClick(R.id.btnSignup)
    public void handleSignUp() {

        loginPresenter.registerNewUser(editTxtEmail.getText().toString(),
                editTxtPassword.getText().toString());
    }

    @Override
    @OnClick(R.id.btnSignin)
    public void handleSignIn() {

        loginPresenter.validateLogin(editTxtEmail.getText().toString(),
                editTxtPassword.getText().toString());
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void disableInputs() {
        setInputs(false);
    }

    @Override
    public void enableInputs() {
        setInputs(true);
    }

    @Override
    public void loginError(String error) {
        editTxtEmail.setText("");
        String msgError = String.format(getString(R.string.login_error_message_signin), error);
        editTxtPassword.setError(msgError);
    }

    @Override
    public void navigateToMainScreen() {
        startActivity(new Intent(this, TurnosActivity.class));
    }

    @Override
    public void newUserError(String error) {
        editTxtPassword.setText("");
        String msgError = String.format(getString(R.string.login_error_message_signup), error);
        editTxtPassword.setError(msgError);
    }

    @Override
    public void newUserSuccess() {
        Snackbar.make(container, R.string.login_notice_message_useradded, Snackbar.LENGTH_SHORT).show();
    }

    private void setInputs(boolean enabled) {
        btnSignin.setEnabled(enabled);
        btnSignup.setEnabled(enabled);
        editTxtEmail.setEnabled(enabled);
        editTxtPassword.setEnabled(enabled);
    }

}
