package com.example.learningo;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learningo.activities.AlphabetActivity;
import com.example.learningo.activities.Days;
import com.example.learningo.activities.NumbersActivity;
import com.example.learningo.activities.RandomAlphabetActivity;

public class MainActivity extends AppCompatActivity {

    int alphabetCode = 65;
    int lastAlphabetCode = 90;
    TextToSpeech t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton  abcImageButton = (ImageButton) findViewById(R.id.abcImageButton);
        abcImageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(MainActivity.this, AlphabetActivity.class);
                startActivity(intent);
            }
        });

        ImageButton numbersImageButton = (ImageButton) findViewById(R.id.numbersImageButton);
        numbersImageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(intent);
            }
        });

        ImageButton randomAbcImageButton = (ImageButton) findViewById(R.id.randomAbcImageButton);
        randomAbcImageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(MainActivity.this, RandomAlphabetActivity.class);
                startActivity(intent);
            }
        });

        ImageButton days_btn = (ImageButton) findViewById(R.id.days_btn);
        days_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Days.class);
                startActivity(intent);
            }
        });

        ImageButton months_btn = (ImageButton) findViewById(R.id.months_btn);
        months_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Days.class);
                startActivity(intent);
            }
        });

        ImageButton shapes_btn = (ImageButton) findViewById(R.id.shapes_btn);
        shapes_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Days.class);
                startActivity(intent);
            }
        });

        ImageButton colors_btn = (ImageButton) findViewById(R.id.colors_btn);
        colors_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Days.class);
                startActivity(intent);
            }
        });
    }

}