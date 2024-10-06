package com.example.connect3game;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    // choose alternate color
    // yellow player = 0, red player = 1;

    int[] gameSet = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    // winning positions, set same row, column and diagonal
    int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    int player = 0;
    boolean gameActive = true;
    @SuppressLint("SetTextI18n")
    public void dropIn(View view) {
        ImageView counter = (ImageView) view;

        int tappedCounter = Integer.parseInt((counter.getTag().toString()));
        Log.i("dropIn",counter.getTag().toString());

        if (gameSet[tappedCounter] == 2 && gameActive) {
            gameSet[tappedCounter] = player;

            counter.setTranslationY(-1500);
            if (player == 0) {
                counter.setImageResource(R.drawable.yellow);
                player = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                player = 0;
            }
            counter.animate().translationYBy(1500).rotation(3600).setDuration(300);

            // after game play, check is there any three same or not, that is winning position
            for (int[] winningPosition : winningPositions) {
                if (gameSet[winningPosition[0]] == gameSet[winningPosition[1]] &&
                        gameSet[winningPosition[1]] == gameSet[winningPosition[2]] &&
                        gameSet[winningPosition[0]] != 2) {
                    // someone has won
                    gameActive = false;
                    String winningPlayer = (player == 0) ? "Red" : "Yellow"; // reverse, always changed value after checked

                    Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
                    TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);

                    winnerTextView.setText(winningPlayer + " has won!");
                    winnerTextView.setVisibility(View.VISIBLE);
                    playAgainButton.setVisibility(View.VISIBLE);
                }
            }
        } else if (gameActive) {
            Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
            playAgainButton.setVisibility(View.VISIBLE);
        }
    }

    public void playAgain(View view) {
        // reset all

        Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
        TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);
        winnerTextView.setVisibility(View.INVISIBLE);
        playAgainButton.setVisibility(View.INVISIBLE);

        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
        for(int i = 0; i < gridLayout.getChildCount(); i++) {
            ImageView counter = (ImageView) gridLayout.getChildAt(i);
            // do stuff with child view
            counter.setImageDrawable(null);
        }

        Arrays.fill(gameSet, 2);
        player = 0;
        gameActive = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}