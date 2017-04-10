package com.example.danielnguyen.tapgame;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void buttonStart(View view) {
        Intent openGame = new Intent(MainMenu.this, Countdown.class);
        startActivity(openGame);
    }

    public void instructions(View view) {
        AlertDialog.Builder builder =  new AlertDialog.Builder(this);
        builder.setTitle("How to Play");
        builder.setMessage("Your goal is to tap the light green button until the counter goes to 0. The catch is, you can only tap" +
                " while the background is green. If the background is red and you tap...GAME OVER.");

        builder.show();

    }

    /*public void buttonStartHard(View view) {
        Intent openGameHard = new Intent(MainMenu.this, HardActivity.class);
        startActivity(openGameHard);
    } */
}
