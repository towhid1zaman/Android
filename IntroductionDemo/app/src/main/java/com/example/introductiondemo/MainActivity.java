package com.example.introductiondemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    //interactivity through button
    //an ui for login.
    public void login(View view) {

        EditText userNameEditText = findViewById(R.id.usernameEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);

        Log.i("Info", "Button Pressed");
        Log.i("Username", userNameEditText.toString());
        Log.i("passwordEditText", passwordEditText.toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}