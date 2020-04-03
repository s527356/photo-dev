package com.example.photo_dev;

import android.content.Intent;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Developer extends AppCompatActivity {

    TextView timerTV;
    Button startDevBN, stopDevBN;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);
        timerTV = findViewById(R.id.timerTV);
        startDevBN = findViewById(R.id.startDevBN);
        stopDevBN = findViewById(R.id.stopDevBN);
        lottieAnimationView = findViewById(R.id.potionAnimation);

        startDevBN.setOnClickListener(v -> start());
        stopDevBN.setOnClickListener(v -> stop());
    }

    public void start() {
        startDevBN.setVisibility(View.GONE);

        // Countdown timer for developer
        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                timerTV.setText(millisUntilFinished / 1000 + " Seconds");
            }

            // Moves to stop bath on finish
            public void onFinish() {
                timerTV.setText("");
                Intent intent = new Intent();
                intent.setClass(Developer.this, StopBath.class);
                Developer.this.startActivity(intent);
                Developer.this.finish();
            }
        }.start();

        lottieAnimationView.setVisibility(View.VISIBLE);
        lottieAnimationView.playAnimation();
        stopDevBN.setVisibility(View.VISIBLE);
    }

    // Should reset timer or go back to the beginning?
    public void stop() {
        Intent intent = new Intent();
        intent.setClass(Developer.this,
            StopBath.class);

        Developer.this.startActivity(intent);
        Developer.this.finish();
    }
}
