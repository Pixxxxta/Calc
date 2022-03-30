package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


    }

    public void onSSClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }

    public void onBitClick(View view) {
        Intent intent = new Intent(this, MainMeny.class);
        startActivity(intent);


    }

    public void onKriptClick(View view) {
        Intent intent = new Intent(this, Flagi.class);
        startActivity(intent);


    }
}