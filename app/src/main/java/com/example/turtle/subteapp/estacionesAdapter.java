package com.example.turtle.subteapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

class estacionesAdapter extends BaseAdapter {

    List<String> estaciones;

    public estacionesAdapter(List<String> estacionesList) {
        estaciones = estacionesList;
    }

    @Override
    public int getCount() {
        return estaciones.size();
    }

    @Override
    public Object getItem(int position) {
        return estaciones.get(position);
    }

    @Override
    public long getItemId(int position) {
        return estaciones.get(position).hashCode();
    }

    @Override
    public View getView(int position, View estacionesView, ViewGroup parent) {
        if (estacionesView == null){
            estacionesView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_estacion, parent, false);
        }
        bindLineaItem(estacionesView, estaciones.get(position));
        return estacionesView;
    }

    public void bindLineaItem(final View root, final String estacion){
        TextView estacionTv = root.findViewById(R.id.estacion);
        estacionTv.setText(estacion);
    }
}