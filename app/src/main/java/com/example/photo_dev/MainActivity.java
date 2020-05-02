package com.example.photo_dev;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.xw.repo.BubbleSeekBar;

public class MainActivity extends AppCompatActivity {

    int temperature = 70;
    TextView tempTV;
    BubbleSeekBar bubbleSeekBar;
    Button startBN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bubbleSeekBar = findViewById(R.id.seekBar);
        tempTV = findViewById(R.id.tempTV);
        startBN = findViewById(R.id.startBN);

        startBN.setOnClickListener(v -> start());

        bubbleSeekBar.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onProgressChanged(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {
                tempTV.setText(String.format("Temperature: %d ˚Fahrenheit", progress));
                temperature = progress;
            }

            @Override
            public void getProgressOnActionUp(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat) { }

            @Override
            public void getProgressOnFinally(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) { }
        });

    }

    public void start() {
        Intent intent = new Intent();
        intent.setClass(this, Developer.class);
        intent.putExtra("temperature", temperature);
        MainActivity.this.startActivity(intent);
        MainActivity.this.finish();
    }
}