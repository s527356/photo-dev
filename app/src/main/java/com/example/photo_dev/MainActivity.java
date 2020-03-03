package com.example.photo_dev;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.xw.repo.BubbleSeekBar;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    LottieAnimationView lottieAnimationView;
    private static final int ANIMATION_DISPLAY_TIME = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BubbleSeekBar bubbleSeekBar = (BubbleSeekBar) findViewById(R.id.seekBar);

        final TextView textView = (TextView) findViewById(R.id.txtView);

        bubbleSeekBar.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {
                textView.setText(String.format("Temperature: %d ˚Celsius", progress));
            }

            @Override
            public void getProgressOnActionUp(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat) {

            }

            @Override
            public void getProgressOnFinally(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {

            }
        });

    }


    public void start(View v) {
        BubbleSeekBar bubbleSeekBar = (BubbleSeekBar) findViewById(R.id.seekBar);
        TextView textView = (TextView) findViewById(R.id.txtView);
        TextView textView2 = (TextView) findViewById(R.id.txtView2);
        Button startBTN = (Button) findViewById(R.id.startBTN);
        Intent ini = new Intent(this, Developer.class);

        bubbleSeekBar.setVisibility(View.GONE);

        textView.setVisibility(View.GONE);

        textView2.setVisibility(View.GONE);

        startBTN.setVisibility(View.GONE);

        lottieAnimationView = findViewById(R.id.checkAnimation);
        lottieAnimationView.setVisibility(View.VISIBLE);
        lottieAnimationView.playAnimation();

        new Handler().postDelayed(new Runnable() {
            public void run() {

                Intent intent = new Intent();
                intent.setClass(MainActivity.this,
                        Developer.class);

                MainActivity.this.startActivity(intent);
                MainActivity.this.finish();

            }
        }, ANIMATION_DISPLAY_TIME);
    }
}