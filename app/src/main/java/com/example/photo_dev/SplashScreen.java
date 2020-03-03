package com.example.photo_dev;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class SplashScreen extends AppCompatActivity {

    private static final int SPLASH_DISPLAY_TIME = 2500;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Handler().postDelayed(new Runnable() {
            public void run() {

                Intent intent = new Intent();
                intent.setClass(SplashScreen.this,
                        MainActivity.class);

                SplashScreen.this.startActivity(intent);
                SplashScreen.this.finish();

            }
        }, SPLASH_DISPLAY_TIME);
    }
}
