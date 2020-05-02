package com.example.photo_dev;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class Fixer extends AppCompatActivity {
  Button startFixBN, stopFixBN;
  TextView fixTimerTV, agitateTimerTV;
  LottieAnimationView lottieAnimationView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.content_fixer);

    startFixBN = findViewById(R.id.startFixBN);
    stopFixBN = findViewById(R.id.stopFixBN);
    fixTimerTV = findViewById(R.id.fixTimerTV);
    agitateTimerTV = findViewById(R.id.agitateFixTV);

    startFixBN.setOnClickListener(v -> start());
    stopFixBN.setOnClickListener(v -> stop());
  }

  public void start() {
    new CountDownTimer(120000, 1000) {
      @SuppressLint("SetTextI18n")
      public void onTick(long millisUntilFinished) {
        int second = (int) (millisUntilFinished / 1000);
        fixTimerTV.setText("Agitate for " + second + " Seconds");

        if(second % 30 == 0) { agitate(); }
      }

      // Moves to stop bath on finish
      public void onFinish() {
        fixTimerTV.setText("");
        Intent intent = new Intent();
        intent.setClass(Fixer.this, Rinse.class); //RINSE?
        Fixer.this.startActivity(intent);
        Fixer.this.finish();
      }
    }.start();

    lottieAnimationView = findViewById(R.id.bathAnimation);
    startFixBN.setVisibility(View.GONE);
    lottieAnimationView.setVisibility(View.VISIBLE);
    lottieAnimationView.playAnimation();
    stopFixBN.setVisibility(View.VISIBLE);
  }

  private void agitate() {
    agitateTimerTV.setText("Test");
    new CountDownTimer(5000, 1000) {
      @SuppressLint({"SetTextI18n", "DefaultLocale"})
      public void onTick(long millisUntilFinished) {
        agitateTimerTV.setText(
            String.format("Agitate for %d more seconds", millisUntilFinished / 1000)
        );
      }

      public void onFinish() {
        agitateTimerTV.setText("");
      }
    }.start();
  }

  public void stop() {
    lottieAnimationView = findViewById(R.id.bathAnimation);
    lottieAnimationView.setVisibility(View.GONE);
    Button bathBTN2 = (Button) findViewById(R.id.stopBathBN);
    bathBTN2.setVisibility(View.GONE);
  }
}
