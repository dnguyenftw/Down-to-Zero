package com.example.danielnguyen.tapgame;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Countdown extends AppCompatActivity {

    private CountDownTimer timer;
    private int countingDown;
    TextView countDown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);

        countDown = (TextView)findViewById(R.id.textView2);
        countDown.setText("4");
        timer = new CountDownTimer(4000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                countDown.setText("" + millisUntilFinished/1000);

            }

            @Override
            public void onFinish() {
                Intent startGame = new Intent(Countdown.this, MainActivity.class);
                startActivity(startGame);
            }
        };
        timer.start();
    }
}
