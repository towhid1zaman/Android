package com.example.introductiondemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private final String tag = "MainActivity";

    //interactivity through button
    //an ui for login.
    public void login(View view) {

        EditText userNameEditText = findViewById(R.id.usernameEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);

        Log.i(tag, "Button Pressed");
        Log.i(tag,"Username " + userNameEditText.getText().toString());
        Log.i(tag,"passwordEditText " +  passwordEditText.getText().toString());

        // show an image when button clicked and userName exist
        if (!userNameEditText.getText().toString().isEmpty()) {
            ImageView userImage = findViewById(R.id.userImage);
            userImage.setImageResource(R.drawable.cat);
        } else {
            Toast.makeText(this, "Please fill up the information", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}