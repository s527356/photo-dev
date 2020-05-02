package com.example.photo_dev;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Rinse extends AppCompatActivity {
  Button nextBN;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_rinse);
    nextBN = findViewById(R.id.nextBN);

    nextBN.setOnClickListener(v -> next());
  }

  void next() {
    Intent intent = new Intent();
    intent.setClass(Rinse.this, Hypo_Clear.class); //RINSE?
    Rinse.this.startActivity(intent);
    Rinse.this.finish();
  }
}