package com.example.photo_dev;

import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

public class StopBath extends AppCompatActivity {

    LottieAnimationView lottieAnimationView;
    private static final int ANIMATION_DISPLAY_TIME = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_stop_bath);

    }

    public void start(View v){
        Button bathBTN = (Button) findViewById(R.id.bathBTN);
        Button bathBTN2 = (Button) findViewById(R.id.bathBTN2);

        lottieAnimationView = findViewById(R.id.bathAnimation);

        bathBTN.setVisibility(View.GONE);

        lottieAnimationView.setVisibility(View.VISIBLE);
        lottieAnimationView.playAnimation();

        bathBTN2.setVisibility(View.VISIBLE);
    }

    public void stop(View v) {
        lottieAnimationView = findViewById(R.id.bathAnimation);
        lottieAnimationView.setVisibility(View.GONE);
        Button bathBTN2 = (Button) findViewById(R.id.bathBTN2);
        bathBTN2.setVisibility(View.GONE);
    }
}
