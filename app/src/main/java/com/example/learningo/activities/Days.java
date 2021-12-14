package com.example.learningo.activities;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learningo.R;
import com.example.learningo.util.OnSwipeTouchListener;

import java.util.Locale;

public class Days extends AppCompatActivity {
    TextToSpeech t1;
    int alphabetCode1 = 65;
    int lastAlphabetCode1 = 90;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days);
        process();
    }

    private void process(){
        final TextSwitcher textSwitcher = (TextSwitcher) findViewById(R.id.daysSwitcher);

        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.getDefault());
                }
            }
        });

        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            //Random rnd = new Random();
            //int color = Color.rgb(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255));

            public View makeView() {
                TextView myText = new TextView(Days.this);
                myText.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.FILL_PARENT, FrameLayout.LayoutParams.FILL_PARENT));

                myText.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                myText.setTextSize(200);
                myText.setTypeface(null, Typeface.BOLD);

                myText.setTextColor(Color.WHITE);
                return myText;
            }
        });

        //Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        //Animation out = AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right);


        textSwitcher.setText("Sunday");

        /*textSwitcher.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                t1.speak(alphabetCode+"", TextToSpeech.QUEUE_FLUSH, null);
                return true;
            }
            return false;
        }
        });*/

        textSwitcher.setOnTouchListener(new OnSwipeTouchListener(this.getApplicationContext()) {

            //Animation slideInLeft = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
            //Animation slideOutRight = AnimationUtils.loadAnimation(getApplicationContext(),android.R.anim.slide_out_right);

            private void forwardText () {
                if (alphabetCode1 == lastAlphabetCode1 + 1){
                    alphabetCode1 = 65;
                }else if(alphabetCode1 == 90){
                    alphabetCode1 = 64;
                }

                String text = Character.toString((char) ++alphabetCode1);
                textSwitcher.setText(text);
                t1.speak(text, TextToSpeech.QUEUE_FLUSH, null);
            }


            public void onTouch() {
                t1.speak(Character.toString((char) alphabetCode1), TextToSpeech.QUEUE_FLUSH, null);
            }

            public void onSwipeTop() {
                //Toast.makeText(MainActivity.this, "top", Toast.LENGTH_SHORT).show();
            }

            public void onSwipeRight() {
                //textSwitcher.setOutAnimation(slideOutRight);
                //textSwitcher.setInAnimation(slideInLeft);
                if (alphabetCode1 == lastAlphabetCode1 + 1) {
                    alphabetCode1 = 65;
                }else if (alphabetCode1 == 65) {
                    alphabetCode1 = 91;
                }

                String text = Character.toString((char) --alphabetCode1);
                textSwitcher.setText(text);
                t1.speak(text, TextToSpeech.QUEUE_FLUSH, null);
            }

            public void onSwipeLeft() {

                //textSwitcher.setInAnimation(slideInLeft);
                //textSwitcher.setOutAnimation(slideOutRight);
                forwardText();


            }

            public void onSwipeBottom() {
                //Toast.makeText(MainActivity.this, "bottom", Toast.LENGTH_SHORT).show();
            }

        });
    }

}


