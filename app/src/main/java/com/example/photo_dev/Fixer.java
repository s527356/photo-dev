package com.example.photo_dev;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class Fixer extends AppCompatActivity {

    TextView timerTV, agitateTimerTV;
    Button startDevBN, stopDevBN;
    LottieAnimationView lottieAnimationView;
    int temperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixer);
        timerTV = findViewById(R.id.timerTV);
        agitateTimerTV = findViewById(R.id.agitateTimerTV);
        startDevBN = findViewById(R.id.startDevBN);
        stopDevBN = findViewById(R.id.stopDevBN);
        lottieAnimationView = findViewById(R.id.potionAnimation);

        startDevBN.setOnClickListener(v -> start());
        stopDevBN.setOnClickListener(v -> stop());


    }

    public void start() {
        startDevBN.setVisibility(View.GONE);



        agitateTimerTV.setText("THIS WORKS NOW!");

        stopDevBN.setVisibility(View.VISIBLE);
    }



    // Should reset timer or go back to the beginning?
    public void stop() {
        Intent intent = new Intent();
        intent.setClass(Fixer.this, Developer.class);
        Fixer.this.startActivity(intent);
        Fixer.this.finish();
    }
}
