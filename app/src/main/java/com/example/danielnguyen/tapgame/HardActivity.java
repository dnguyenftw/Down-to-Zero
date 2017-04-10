/* package com.example.danielnguyen.tapgame;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class HardActivity extends AppCompatActivity {

    private Button myButton;
    private int counterValue = 15;
    private TextView counterView;
    TextView textViewTimer;

    private RelativeLayout backgroundLayout;

    private boolean isAlternate = false;

    private CountDownTimer timer;

    private MediaPlayer mpError;
    private MediaPlayer mpSuccess;
    private MediaPlayer mpPop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard);

     /* mpError = MediaPlayer.create(HardActivity.this, R.raw.error_sound);
        mpSuccess = MediaPlayer.create(HardActivity.this,R.raw.success);
        mpPop = MediaPlayer.create(HardActivity.this,R.raw.pop_sound);
    */

     /*   myButton = (Button) findViewById(R.id.button);
        counterView = (TextView) findViewById(R.id.View);
        textViewTimer = (TextView) findViewById(R.id.textViewTimer);
        backgroundLayout = (RelativeLayout)findViewById(R.id.backgroundLayout);

        textViewTimer.setText("15");


        timer = new CountDownTimer(10000, 500) {
            @Override
            public void onTick(long millisUntilFinished) {
                textViewTimer = (TextView) findViewById(R.id.textViewTimer);
                int secondsRemaining = (int) (millisUntilFinished/1000);
                textViewTimer.setText(String.valueOf(millisUntilFinished/1000));

                Random number = new Random();
                int randomNum = number.nextInt((15 - 0) + 1) + 0;

                if (randomNum <= 3){
                    setBackgroundRed();
                    isAlternate = false;
                }else {
                    setBackgroundGreen();
                    isAlternate = true;
                }
//                if (isAlternate){
//                    isAlternate = false;
//                    setBackgroundRed();
//
//
//                }else{
//                    isAlternate = true;
//                    setBackgroundGreen();
//                    myButton.setEnabled(true);
//                }

            }

            @Override
            public void onFinish() {
//               AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                builder.setTitle("Game Over");
//                builder.setMessage("Your score was: " + String.valueOf(counterValue));
//                builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                        Intent restartActivity = new Intent(MainActivity.this, MainActivity.class);
//                        startActivity(restartActivity);
//                    }
//                });
//
//                builder.show();
                if (counterValue != 0){
                    new SweetAlertDialog(HardActivity.this, SweetAlertDialog.ERROR_TYPE)
                            .setTitleText("YOU FAILED!!!")
                            .setContentText("You tapped down to: " + String.valueOf(counterValue))
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sweetAlertDialog) {
                                    mpError.start();
                                    Intent restartGame = new Intent(HardActivity.this, HardActivity.class);
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
        mpPop.start();
        if (!isAlternate) {
            myButton.setEnabled(false);
            timer.cancel();
            new SweetAlertDialog(HardActivity.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("You FAILED")
                    .setContentText("You only tapped down to: " + String.valueOf(counterValue) + " times.")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            mpError.start();
                            Intent restartGame = new Intent(HardActivity.this, HardActivity.class);
                            startActivity(restartGame);
                        }
                    })
                    .show();
        }
        counterValue--;
        counterView.setText(String.valueOf(counterValue));
        if (counterValue == 0){
            new SweetAlertDialog(HardActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("You WON!!")
                    .setContentText("You tapped all the way down to: " + String.valueOf(counterValue))
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            mpSuccess.start();
                            Intent restartGame = new Intent(HardActivity.this,HardActivity.class);
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

*/