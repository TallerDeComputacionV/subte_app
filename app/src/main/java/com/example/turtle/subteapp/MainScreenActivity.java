package com.example.turtle.subteapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainScreenActivity extends AppCompatActivity {

    private LineaAdapter lineaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);
        List<Linea> lineaList = new ArrayList<>();
        initLineaList(lineaList);
        ListView listView = findViewById(R.id.linea_container);
        lineaAdapter = new LineaAdapter(lineaList);
        listView.setAdapter(lineaAdapter);
    }

    private void initLineaList(final List<Linea> lineaList){

        SubteApiClient.getClient().getLineas().enqueue(new Callback<List<Linea>>() {
            @Override
            public void onResponse(Call<List<Linea>> call, Response<List<Linea>> response) {
                lineaList.clear();
                lineaList.addAll(response.body());
                lineaAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Linea>> call, Throwable throwable) {
                Toast.makeText(MainScreenActivity.this, throwable.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }

}