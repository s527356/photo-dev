package com.example.photo_dev;

import android.content.Intent;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class Developer extends AppCompatActivity {

    LottieAnimationView lottieAnimationView;
    private static final int ANIMATION_DISPLAY_TIME = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);



    }

    public void start(View v){

        Button agiBTN = (Button) findViewById(R.id.agiBTN);
        Button agiStopBTN = (Button) findViewById(R.id.agiBTN2);

        lottieAnimationView = findViewById(R.id.potionAnimation);


        agiBTN.setVisibility(View.GONE);

        lottieAnimationView.setVisibility(View.VISIBLE);
        lottieAnimationView.playAnimation();

        agiStopBTN.setVisibility(View.VISIBLE);
    }

    public void stop(View v){

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
