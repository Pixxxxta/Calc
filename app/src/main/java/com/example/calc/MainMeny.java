package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainMeny extends AppCompatActivity {
    EditText numberField;
    int a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_meny);
        numberField = findViewById(R.id.editTextNumber);
    }

    public void onMenuClick(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);

    }

    public void onBitKonvClick(View view) {
        String number = numberField.getText().toString();
        if(number.length() > 0 && number.length() < 10) {
            if (Integer.parseInt(number)<0){
                numberField.setText("");
                Toast toast = Toast.makeText(this, "Вы ввели что-то не то!", Toast.LENGTH_LONG);
                toast.show();
            }
            else {
                float a = Integer.parseInt(number) / 47269;
                numberField.setText(String.valueOf(a));
            }
        }
        else{
            if (number.length() == 0) {
                numberField.setText("");
                Toast toast = Toast.makeText(this, "Вы ничего не ввели!", Toast.LENGTH_LONG);
                toast.show();
            }
            if (number.length()  < 10) {
                numberField.setText("");
                Toast toast = Toast.makeText(this, "Вы ввели слишком много символов!", Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }
}