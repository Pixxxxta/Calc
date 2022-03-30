package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText numberField;
    Spinner spinner;
    Integer[] countries = { 2, 3, 4, 5, 6, 7, 8, 9 , 11, 12, 13, 14, 15, 16};
    String ss;
    int ss1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberField = findViewById(R.id.numberField);
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, countries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
    // сохранение состояния
    public void onNumberClick(View view) {
        Button button = (Button)view;
        String number = button.getText().toString();
        numberField.append(button.getText());

    }
    public void onDelClick(View view) {
        numberField.setText("");


    }
    public void onMenuClick(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);

    }
    public void onAnsClick(View view) {

        ss = spinner.getSelectedItem().toString();
        ss1 = Integer.parseInt(ss);

        String number = numberField.getText().toString();
        if (number.length() > 0 && number.length() < 10) {
            if (number.contains("A") || number.contains("B") || number.contains("C") ||number.contains("D") || number.contains("E") || number.contains("F")){
                Toast toast = Toast.makeText(this, "В поле для ввода остались буквы!", Toast.LENGTH_LONG);
                toast.show();
            }
            else{
            Character n1 = number.charAt(0);
            if (n1 == '0') {
                String string="";
                numberField.setText(string);
            }
            else{
                if (ss1 > 10){
                    int a = Integer.parseInt(number);
                    System.out.println(a);
                    String b = "";
                    while (a > 0) {
                        if (a % ss1 > 10){
                            if (a % ss1 == 10){
                                b += "A";
                            }
                            if (a % ss1 == 11){
                                b += "B";
                            }
                            if (a % ss1 == 12){
                                b += "C";
                            }
                            if (a % ss1 == 13){
                                b += "D";
                            }
                            if (a % ss1 == 14){
                                b += "E";
                            }
                            if (a % ss1 == 15){
                                b += "F";
                            }
                        }
                        else{b += String.valueOf(a % ss1);}

                        System.out.println(b);
                        a = a / ss1;
                    }
                    StringBuilder sb = new StringBuilder(b);
                    sb.reverse();
                    numberField.setText(String.valueOf(sb));
                }
                else {
                    int a = Integer.parseInt(number);
                    System.out.println(a);
                    String b = "";
                    while (a > 0) {
                        b += String.valueOf(a % ss1);
                        System.out.println(b);
                        a = a / ss1;
                    }
                    StringBuilder sb = new StringBuilder(b);
                    sb.reverse();
                    numberField.setText(String.valueOf(sb));
                }
            }
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