package com.example.connect3game;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // choose alternate color
    // yellow player = 0, red player = 1;

    private int[] gameSet = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    // winning positions, set same row, column and diagonal
    private int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    private int player = 1;
    public void dropIn(View view) {
        ImageView counter = (ImageView) view;

        int tappedCounter = Integer.parseInt((counter.getTag().toString()));
        Log.i("dropIn",counter.getTag().toString());

        if (gameSet[tappedCounter] == 2) {
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

                    String winningPlayer = (player == 0) ? "Red" : "Yellow"; // reverse, always changed value after checked
                    Toast.makeText(this, winningPlayer + " won the game", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}