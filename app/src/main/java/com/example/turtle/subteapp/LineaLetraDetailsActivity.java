package com.example.turtle.subteapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

public class LineaLetraDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linea_details);
        Bundle arguments = getIntent().getExtras();
        Linea linea = new Gson().fromJson(arguments.getString("linea"), Linea.class);

        List<String> estacionesList = linea.getEstaciones();
        ListView listView = findViewById(R.id.estacionesList);
        listView.setAdapter(new estacionesAdapter(estacionesList));

        String letra = linea.getLetra();
        TextView idlinea = findViewById(R.id.idlinea);
        idlinea.append(letra);
    }
}
