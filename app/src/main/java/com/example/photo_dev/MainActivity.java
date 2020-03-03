package com.example.photo_dev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextSwitcher;
import android.widget.TextView;

import com.xw.repo.BubbleSeekBar;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BubbleSeekBar bubbleSeekBar = (BubbleSeekBar)findViewById(R.id.seekBar);

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
}
