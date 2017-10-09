package com.example.android.befitdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread t= new Thread()
        {
            @Override
            public void run() {
                try
                {
                    sleep(1500);     //milliseconds
                    Intent intent= new Intent(getApplicationContext(),Login.class);
                    startActivity(intent);
                }
                catch(Exception e)
                {
                    Log.v("Error",e.getMessage().toString());
                }
            }
        };
        t.start();

    }
}
