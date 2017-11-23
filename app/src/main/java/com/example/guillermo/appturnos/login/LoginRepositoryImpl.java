package com.example.guillermo.appturnos.login;

import android.support.annotation.NonNull;

import com.example.guillermo.appturnos.domain.FirebaseHelper;
import com.example.guillermo.appturnos.lib.EventBus;
import com.example.guillermo.appturnos.lib.GreenRobotEventBus;
import com.example.guillermo.appturnos.login.entities.User;
import com.example.guillermo.appturnos.login.events.LoginEvent;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;


/**
 * Created by ykro.
 */
public class LoginRepositoryImpl implements LoginRepository {
    private FirebaseHelper helper;
    private DatabaseReference dataReference;
    private DatabaseReference myUserReference;

    public LoginRepositoryImpl() {
        helper = FirebaseHelper.getInstance();
        dataReference = helper.getDataReference();
        myUserReference = helper.getMyUserReference();
    }

    @Override
    public void signUp(final String nombre, final String apellido, final String telefono, final String email, final String password) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        postEvent(LoginEvent.onSignUpSuccess);
                        signIn(nombre, apellido, telefono, email, password);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        postEvent(LoginEvent.onSignUpError, e.getMessage());
                    }
                });
    }

    @Override
    public void signIn(final String nombre, final String apellido, final String telefono, String email, String password) {
        /*try {
           FirebaseAuth auth = FirebaseAuth.getInstance();
            auth.signInWithEmailAndPassword(email, password)
                    .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            myUserReference = helper.getMyUserReference();
                            myUserReference.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot snapshot) {
                                    initSignIn(nombre, apellido, telefono, snapshot);
                                }

                                @Override
                                public void onCancelled(DatabaseError firebaseError) {
                                    postEvent(LoginEvent.onSignInError, firebaseError.getMessage());
                                }
                            });
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            postEvent(LoginEvent.onSignInError, e.getMessage());
                        }
                    });
        } catch (Exception e) {
            postEvent(LoginEvent.onSignInError, e.getMessage());
        }*/

    }

    @Override
    public void checkAlreadyAuthenticated() {
        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            myUserReference = helper.getMyUserReference();
            myUserReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    initSignIn(null, null, null, snapshot);
                }

                @Override
                public void onCancelled(DatabaseError firebaseError) {
                    postEvent(LoginEvent.onSignInError, firebaseError.getMessage());
                }
            });
        } else {
            postEvent(LoginEvent.onFailedToRecoverSession);
        }
    }

    private void registerNewUser(String nombre, String apellido, String telefono) {
        String email = helper.getAuthUserEmail();
        if (email != null) {
            User currentUser = new User(nombre, apellido, telefono, email, true, false);
            myUserReference.setValue(currentUser);
        }
    }

    private void initSignIn(String nombre, String apellido, String telefono, DataSnapshot snapshot) {
        User currentUser = snapshot.getValue(User.class);

        if (currentUser == null) {
            registerNewUser(nombre, apellido, telefono);
        }
        helper.changeUserConnectionStatus(User.ONLINE);
        postEvent(LoginEvent.onSignInSuccess);
    }

    private void postEvent(int type) {
        postEvent(type, null);
    }

    private void postEvent(int type, String errorMessage) {
        LoginEvent loginEvent = new LoginEvent();
        loginEvent.setEventType(type);
        if (errorMessage != null) {
            loginEvent.setErrorMesage(errorMessage);
        }

        EventBus eventBus = GreenRobotEventBus.getInstance();
        eventBus.post(loginEvent);
    }

}
