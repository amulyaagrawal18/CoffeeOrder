package com.example.android.coffeeorder;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class home_activity extends AppCompatActivity
{
    private static int SPLASH_TIME_OUT =3000;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeintent=new Intent(home_activity.this,contacts.class);
                startActivity(homeintent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
