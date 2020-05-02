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
    double totalTime;
    TextView tempTV, timeInfoTV;
    BubbleSeekBar bubbleSeekBar;
    Button startBN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bubbleSeekBar = findViewById(R.id.seekBar);
        tempTV = findViewById(R.id.tempTV);
        timeInfoTV = findViewById(R.id.timeInfoTV);
        startBN = findViewById(R.id.startBN);

        startBN.setOnClickListener(v -> start());

        bubbleSeekBar.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onProgressChanged(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {
                tempTV.setText(String.format("Temperature: %d ˚Fahrenheit", progress));
                temperature = progress;

                if (temperature == 65) {
                    totalTime = 7.5 + 28.5;
                    timeInfoTV.setText("Development time: " + totalTime + " minutes");
                }

                else if (temperature == 66) {
                    totalTime = 7.25 + 28.5;
                    timeInfoTV.setText("Development time: " + totalTime + " minutes");
                }

                else if (temperature == 67) {
                    totalTime = 7 + 28.5;
                    timeInfoTV.setText("Development time: " + totalTime + " minutes");
                }

                else if (temperature == 68) {
                    totalTime = 6.5 + 28.5;
                    timeInfoTV.setText("Development time: " + totalTime + " minutes");
                }

                else if (temperature == 69) {
                    totalTime = 6 + 28.5;
                    timeInfoTV.setText("Development time: " + totalTime + " minutes");
                }

                else if (temperature == 70) {
                    totalTime = 5.5 + 28.5;
                    timeInfoTV.setText("Development time: " + totalTime + " minutes");
                }

                else if (temperature == 71) {
                    totalTime = 5.25 + 28.5;
                    timeInfoTV.setText("Development time: " + totalTime + " minutes");
                }

                else if (temperature == 72) {
                    totalTime = 5 + 28.5;
                    timeInfoTV.setText("Development time: " + totalTime + " minutes");
                }

                else if (temperature == 73) {
                    totalTime = 4.75 + 28.5;
                    timeInfoTV.setText("Development time: " + totalTime + " minutes");
                }

                else if (temperature == 74) {
                    totalTime = 4.5 + 28.5;
                    timeInfoTV.setText("Development time: " + totalTime + " minutes");
                }

                else if (temperature == 75) {
                    totalTime = 4.25 + 28.5;
                    timeInfoTV.setText("Development time: " + totalTime + " minutes");
                }

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