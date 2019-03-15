package com.satrio.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.satrio.myapplication.adapter.PreferenceHelper;

public class Splash extends AppCompatActivity {

    PreferenceHelper instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        instance = PreferenceHelper.getInstance(getApplicationContext());
        int splasInterval = 2500;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!instance.isLogin()){
                    Intent i = new Intent(Splash.this, Login.class);
                    startActivity(i);
                    finish();
                }else{
                    Intent i = new Intent(Splash.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        }, splasInterval);


    }

}
