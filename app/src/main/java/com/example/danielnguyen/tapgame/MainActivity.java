package com.example.danielnguyen.tapgame;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.pedant.SweetAlert.SweetAlertDialog;
public class MainActivity extends Activity {
    private Button myButton;
    //the starting number of taps.
    private int counterValue = 30;
    private TextView counterView;
    TextView textViewTimer;
    private RelativeLayout backgroundLayout;
    private boolean isAlternate = false;
    private CountDownTimer timer;
    //plays sounds effects in the game.
//    private MediaPlayer mpError;
//    private MediaPlayer mpSuccess;
//    private MediaPlayer mpPop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    /*    mpError = MediaPlayer.create(MainActivity.this, R.raw.error_sound);
        mpSuccess = MediaPlayer.create(MainActivity.this,R.raw.success);
        mpPop = MediaPlayer.create(MainActivity.this,R.raw.pop_sound);
    */
        myButton = (Button) findViewById(R.id.button);
        counterView = (TextView) findViewById(R.id.View);
        textViewTimer = (TextView) findViewById(R.id.textViewTimer);
        backgroundLayout = (RelativeLayout)findViewById(R.id.backgroundLayout);
        textViewTimer.setText("15");

        timer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textViewTimer = (TextView) findViewById(R.id.textViewTimer);
                int secondsRemaining = (int) (millisUntilFinished/1000);
                textViewTimer.setText(String.valueOf(millisUntilFinished/1000));
                if (isAlternate){
                    isAlternate = false;
                    setBackgroundRed();
                }else{
                    isAlternate = true;
                    setBackgroundGreen();
                    myButton.setEnabled(true);
                }
            }

            @Override
            public void onFinish() {
                if (counterValue != 0){
                    new SweetAlertDialog(MainActivity.this, SweetAlertDialog.ERROR_TYPE)
                            .setTitleText("YOU FAILED!!!")
                            .setContentText("You tapped down to: " + String.valueOf(counterValue))
                            .setConfirmText("Main Menu")
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sweetAlertDialog) {
                                    Intent restartGame = new Intent(MainActivity.this, MainMenu.class);
                                    startActivity(restartGame);
                                }
                            })
                            .show();
                }
            }
        };
        timer.start();
    }

    public void buttonClick(View view){
        //if user taps button while background is red, the game is lost.
        if (!isAlternate) {
            myButton.setEnabled(false);
            timer.cancel();
            new SweetAlertDialog(MainActivity.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("You FAILED")
                    .setContentText("You only tapped down to: " + String.valueOf(counterValue) + " times.")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            Intent restartGame = new Intent(MainActivity.this,MainActivity.class);
                            startActivity(restartGame);
                        }
                    })
                    .show();
        }
        //every tap decreases the tap value by one.
        counterValue--;
        counterView.setText(String.valueOf(counterValue));
        //if the user taps down to zero, the game is won.
        if (counterValue == 0){
            new SweetAlertDialog(MainActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("You WON!!")
                    .setContentText("You tapped all the way down to: " + String.valueOf(counterValue))
                    .setConfirmText("Hooray!")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            Intent restartGame = new Intent(MainActivity.this, MainMenu.class);
                            startActivity(restartGame);
                        }
                    })
                    .show();
        }
    }
    public void setBackgroundGreen(){
        backgroundLayout.setBackgroundColor(Color.parseColor("#4CAF50"));
    }
    private void setBackgroundRed(){
        backgroundLayout.setBackgroundColor(Color.parseColor("#F44336"));
    }
}
