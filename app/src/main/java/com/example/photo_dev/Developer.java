package com.example.photo_dev;

import android.content.Intent;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Developer extends AppCompatActivity {

    TextView timerTV;
    Button agiBTN, agiStopBTN;
    LottieAnimationView lottieAnimationView;
    private static final int ANIMATION_DISPLAY_TIME = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);
        timerTV = findViewById(R.id.timerTV);
    }

    public void start(View v) {
        agiBTN = findViewById(R.id.agiBTN);
        agiStopBTN = findViewById(R.id.agiBTN2);

        lottieAnimationView = findViewById(R.id.potionAnimation);

        agiBTN.setVisibility(View.GONE);

        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                timerTV.setText(millisUntilFinished / 1000 + " Seconds");
            }

            public void onFinish() {
                timerTV.setText("");
            }
        }.start();

        lottieAnimationView.setVisibility(View.VISIBLE);
        lottieAnimationView.playAnimation();

        agiStopBTN.setVisibility(View.VISIBLE);
    }

    public void stop(View v) {

        lottieAnimationView = findViewById(R.id.potionAnimation);
        lottieAnimationView.setVisibility(View.GONE);
        Button agiStopBTN = (Button) findViewById(R.id.agiBTN2);
        agiStopBTN.setVisibility(View.GONE);

        lottieAnimationView = findViewById(R.id.checkAnimation);
        lottieAnimationView.setVisibility(View.VISIBLE);
        lottieAnimationView.playAnimation();

        new Handler().postDelayed(new Runnable() {
            public void run() {

                Intent intent = new Intent();
                intent.setClass(Developer.this,
                        StopBath.class);

                Developer.this.startActivity(intent);
                Developer.this.finish();

            }
        }, ANIMATION_DISPLAY_TIME);
    }
}
