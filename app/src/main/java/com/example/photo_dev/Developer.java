package com.example.photo_dev;

import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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
        lottieAnimationView.setVisibility(View.VISIBLE);

        agiBTN.setVisibility(View.GONE);
        lottieAnimationView.playAnimation();

        agiStopBTN.setVisibility(View.VISIBLE);
    }

    public void stop(View v){

        lottieAnimationView = findViewById(R.id.potionAnimation);
        Button agiStopBTN = (Button) findViewById(R.id.agiBTN2);

        lottieAnimationView.setVisibility(View.VISIBLE);

        agiStopBTN.setVisibility(View.VISIBLE);

    }

}
