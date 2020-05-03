package com.example.photo_dev;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class Rinse extends AppCompatActivity {


    TextView timerTV, agitateTimerTV;
    Button startDevBN, stopDevBN;
    LottieAnimationView lottieAnimationView;
    Animation animBlink;
    int temperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rinse);

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
            agitateTimerTV.setText("Rinse with water by filling & dumping tank 5-6 times");
            animBlink = AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.blink);
            agitateTimerTV.startAnimation(animBlink);
            lottieAnimationView.setVisibility(View.VISIBLE);
            lottieAnimationView.playAnimation();
            stopDevBN.setVisibility(View.VISIBLE);
        }



        public void stop() {
            Intent intent = new Intent();
            intent.setClass(Rinse.this, StopBath.class);
            Rinse.this.startActivity(intent);
            Rinse.this.finish();
        }
    }
