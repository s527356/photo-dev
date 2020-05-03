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

public class Hypo extends AppCompatActivity {

    TextView timerTV, agitateTimerTV;
    Button startDevBN, stopDevBN;
    LottieAnimationView lottieAnimationView;
    Animation animBlink;
    int temperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hypo);

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

        agitateTimerTV.setText("Make sure to agitate continuously");
        animBlink = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.blink);
        agitateTimerTV.startAnimation(animBlink);

        new CountDownTimer(120000, 1000) {
            @SuppressLint("SetTextI18n")
            public void onTick(long millisUntilFinished) {
                int second = (int) (millisUntilFinished / 1000);
                int minute = (int) ((second / 1000) /60);
                int seconds = (int)((second / 1000) % 60);
                timerTV.setText(second + " Seconds");
            }

            // Moves to stop bath on finish
            public void onFinish() {
                timerTV.setText("");
                Intent intent = new Intent();
                intent.setClass(Hypo.this, StopBath.class);
                Hypo.this.startActivity(intent);
                Hypo.this.finish();
            }
        }.start();

        lottieAnimationView.setVisibility(View.VISIBLE);
        lottieAnimationView.playAnimation();
        stopDevBN.setVisibility(View.VISIBLE);
    }


    public void stop() {
        Intent intent = new Intent();
        intent.setClass(Hypo.this,
                StopBath.class);

        Hypo.this.startActivity(intent);
        Hypo.this.finish();
    }
}
