package com.example.introductiondemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private String tag = "MainActivity";

    //interactivity through button
    //an ui for login.
    public void login(View view) {

        EditText userNameEditText = (EditText) findViewById(R.id.usernameEditText);
        EditText passwordEditText = (EditText) findViewById(R.id.passwordEditText);

        Log.i(tag, "Button Pressed");
        Log.i(tag,"Username " + userNameEditText.getText().toString());
        Log.i(tag,"passwordEditText " +  passwordEditText.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}