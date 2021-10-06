package com.example.adaptadores_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerCoches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerCoches = findViewById(R.id.spinnerCoches);
        String[] coches = {"BMW", "Seat", "Tesla", "Citroen", "Peugeot"};

        ArrayAdapter<String> adaptador;
        adaptador = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, coches);
        spinnerCoches.setAdapter(adaptador);

        spinnerCoches.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Has seleccionado el coche: " + adapterView.getSelectedItem().toString(),
                        Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}