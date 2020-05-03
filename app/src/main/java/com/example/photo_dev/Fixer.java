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

public class Fixer extends AppCompatActivity {

    TextView timerTV, agitateTimerTV;
    Button startDevBN, stopDevBN;
    LottieAnimationView lottieAnimationView;
    Animation animBlink;
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

        // Countdown timer for developer
        new CountDownTimer(600000, 1000) {
            @SuppressLint("SetTextI18n")
            public void onTick(long millisUntilFinished) {
                int second = (int) (millisUntilFinished / 1000);
                int minute = (int) ((millisUntilFinished / 1000) /60);
                int seconds = (int)((millisUntilFinished / 1000) % 60);
                if (minute < 10 && seconds < 10){
                    timerTV.setText("0" + minute + " : 0" +  seconds);
                }
                else if (minute < 10) {
                    timerTV.setText("0" + minute + " : " + seconds);
                }
                else if (seconds < 10) {
                    timerTV.setText(minute + " : 0" + seconds);
                }

                if(second % 30 == 0) { agitate(); }
                // Agitate for 5 seconds every 30 seconds
            }

            // Moves to stop bath on finish
            public void onFinish() {
                timerTV.setText("");
                Intent intent = new Intent();
                intent.setClass(Fixer.this, StopBath.class);
                Fixer.this.startActivity(intent);
                Fixer.this.finish();
            }
        }.start();

        lottieAnimationView.setVisibility(View.VISIBLE);
        lottieAnimationView.playAnimation();
        stopDevBN.setVisibility(View.VISIBLE);
    }

    // Agitate for 5 seconds every 30 seconds
    private void agitate() {
        agitateTimerTV.setText("Test");
        new CountDownTimer(5000, 1000) {
            @SuppressLint({"SetTextI18n", "DefaultLocale"})
            public void onTick(long millisUntilFinished) {
                agitateTimerTV.setText(
                        String.format("Agitate for %d more seconds", millisUntilFinished / 1000)
                );
                animBlink = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.blink);
                agitateTimerTV.startAnimation(animBlink);
            }

            public void onFinish() {
                agitateTimerTV.setText("");
                agitateTimerTV.clearAnimation();
            }
        }.start();
    }



    // Should reset timer or go back to the beginning?
    public void stop() {
        Intent intent = new Intent();
        intent.setClass(Fixer.this, Rinse.class);
        Fixer.this.startActivity(intent);
        Fixer.this.finish();
    }
}
