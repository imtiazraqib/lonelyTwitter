package ca.ualberta.cs.lonelytwitter;

import android.app.Application;

import com.google.firebase.FirebaseApp;

public class FireBaseInitialize extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseApp.initializeApp(this);
    }

}