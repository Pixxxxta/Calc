package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Flagi extends AppCompatActivity {

    ArrayList<State> states = new ArrayList<State>();
    ListView countriesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flagi);
        setInitialData();
        // получаем элемент ListView
        countriesList = findViewById(R.id.countriesList);
        // создаем адаптер
        StateAdapter stateAdapter = new StateAdapter(this, R.layout.list_item, states);
        // устанавливаем адаптер
        countriesList.setAdapter(stateAdapter);
        // слушатель выбора в списке
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                // получаем выбранный пункт
                State selectedState = (State)parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Был выбран пункт " + selectedState.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        };
        countriesList.setOnItemClickListener(itemListener);
    }

    private void setInitialData(){

        states.add(new State ("Биткоин", "Сатоси Накамото", R.drawable.a1));
        states.add(new State ("Леткоин", "Чарльз Ли", R.drawable.a2));
        states.add(new State ("Догекоин", "Билл Маркус", R.drawable.a3));
        states.add(new State ("Dash", "Эван Даффилд", R.drawable.a4));
        states.add(new State ("Ethereum", "Vitalik Buterin", R.drawable.a5));
    }
    public void onMenuClick(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);

    }
}