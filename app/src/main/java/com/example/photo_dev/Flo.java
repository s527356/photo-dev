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

public class Flo extends AppCompatActivity {

    TextView timerTV, agitateTimerTV;
    Button startDevBN, stopDevBN;
    LottieAnimationView lottieAnimationView;
    Animation animBlink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flo);

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

        agitateTimerTV.setText("Swirl reel in solution");
        animBlink = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.blink);
        agitateTimerTV.startAnimation(animBlink);

        new CountDownTimer(30000, 1000) {
            @SuppressLint("SetTextI18n")
            public void onTick(long millisUntilFinished) {
                int second = (int) (millisUntilFinished / 1000);
                int minute = (int) ((millisUntilFinished / 1000) /60);
                int seconds = (int)((millisUntilFinished / 1000) % 60);

                if (second < 10) {
                    timerTV.setText( "0" + second);
                }

            }

            // Moves to stop bath on finish
            public void onFinish() {
                timerTV.setText("");
                Intent intent = new Intent();
                intent.setClass(Flo.this, Done.class);
                Flo.this.startActivity(intent);
                Flo.this.finish();
            }
        }.start();

        lottieAnimationView.setVisibility(View.VISIBLE);
        lottieAnimationView.playAnimation();
        stopDevBN.setVisibility(View.VISIBLE);
    }


    public void stop() {
        Intent intent = new Intent();
        intent.setClass(Flo.this,
                Done.class);

        Flo.this.startActivity(intent);
        Flo.this.finish();
    }
}

