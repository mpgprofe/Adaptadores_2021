package com.example.adaptadores_2021;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerCoches,spinnerPlus;
    String[] coches;
    String[] lemas;
    int[] logos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerCoches = findViewById(R.id.spinnerCoches);
        coches = new String[]{"BMW", "Seat", "Tesla", "Citroen", "Peugeot"};
        lemas = new String[]{"Me gusta conducir", "Enjoinering", "Acelera que flipas", "Inspirado por ti", "Motion and Emotion"};
        logos = new int[]{R.drawable.bmw, R.drawable.seat, R.drawable.tesla, R.drawable.citroen, R.drawable.peugeot};
        spinnerPlus = findViewById(R.id.spinnerPlus);


        ArrayAdapter<String> adaptador;
        adaptador = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, coches);
        spinnerCoches.setAdapter(adaptador);

        //------

        AdaptadorParaCoches adaptadorParaCoches = new AdaptadorParaCoches(this,R.layout.coches, coches);
        spinnerPlus.setAdapter(adaptadorParaCoches);


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

    private class AdaptadorParaCoches extends ArrayAdapter<String> {

        public AdaptadorParaCoches(@NonNull Context context, int resource, @NonNull String[] objects) {
            super(context, resource, objects);

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            return rellenarFila(position, convertView, parent);
        }

        @Override
        public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            return rellenarFila(position, convertView, parent);
        }

        public View rellenarFila(int posicion, View view, ViewGroup padre) {

            LayoutInflater inflater = getLayoutInflater();
            View mifila = inflater.inflate(R.layout.coches, padre, false);

            TextView titulo = mifila.findViewById(R.id.textViewMarca);
            titulo.setText(coches[posicion]);

            ImageView logo = mifila.findViewById(R.id.imageView);
            logo.setImageResource(logos[posicion]);

            TextView textViewlema = mifila.findViewById(R.id.textViewLema);
            textViewlema.setText(lemas[posicion]);

            return mifila;
        }


    }
}