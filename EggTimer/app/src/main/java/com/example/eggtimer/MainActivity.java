package com.example.eggtimer;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView countDownTextView;
    SeekBar timerSeekBar;

    public void buttonClicked(View view) {
        Log.i("Button Pressed", "Button working");

        CountDownTimer countDownTimer = new CountDownTimer(timerSeekBar.getProgress()* 1000L + 100, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                updateTimer((int)millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.airhorn);
                mediaPlayer.start();
            }
        }.start();
    }

    public void updateTimer(int secondsLeft) {
        int minutes = secondsLeft/60;
        int seconds = secondsLeft - (minutes * 60);

        String secondString = Integer.toString(seconds);
        if (seconds < 10) {
            secondString = "0" + secondString;
        }
        countDownTextView.setText(minutes + ":" + secondString);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerSeekBar = findViewById(R.id.timerSeekBar);
        countDownTextView = findViewById(R.id.countDownTextView);

        timerSeekBar.setMax(10*60);
        timerSeekBar.setProgress(30);
        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateTimer(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}