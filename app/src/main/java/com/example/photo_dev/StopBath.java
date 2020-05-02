package com.example.photo_dev;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StopBath extends AppCompatActivity {
    Button startBathBN, stopBathBN;
    TextView bathTimerTV;
    LottieAnimationView lottieAnimationView;
    private static final int ANIMATION_DISPLAY_TIME = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_stop_bath);

        startBathBN = findViewById(R.id.startBathBN);
        stopBathBN = findViewById(R.id.stopBathBN);
        bathTimerTV = findViewById(R.id.bathTimerTV);

        startBathBN.setOnClickListener(v -> start());
        stopBathBN.setOnClickListener(v -> stop());
    }

    public void start() {
        new CountDownTimer(120000, 1000) {
            @SuppressLint("SetTextI18n")
            public void onTick(long millisUntilFinished) {
                int second = (int) (millisUntilFinished / 1000);
                bathTimerTV.setText("Agitate for " + second + " Seconds");
            }

            // Moves to stop bath on finish
            public void onFinish() {
                bathTimerTV.setText("");
                Intent intent = new Intent();
                intent.setClass(StopBath.this, Fixer.class);
                StopBath.this.startActivity(intent);
                StopBath.this.finish();
            }
        }.start();

        lottieAnimationView = findViewById(R.id.bathAnimation);
        startBathBN.setVisibility(View.GONE);
        lottieAnimationView.setVisibility(View.VISIBLE);
        lottieAnimationView.playAnimation();
        stopBathBN.setVisibility(View.VISIBLE);
    }

    public void stop() {
        lottieAnimationView = findViewById(R.id.bathAnimation);
        lottieAnimationView.setVisibility(View.GONE);
        Button bathBTN2 = (Button) findViewById(R.id.stopBathBN);
        bathBTN2.setVisibility(View.GONE);
    }
}
