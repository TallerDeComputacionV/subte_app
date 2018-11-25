package com.example.turtle.subteapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

class LineaAdapter extends BaseAdapter {

    List<Linea> lineas;

    public LineaAdapter(List<Linea> lineaList) {
        lineas = lineaList;
    }

    @Override
    public int getCount() {
        return lineas.size();
    }

    @Override
    public Object getItem(int position) {
        return lineas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lineas.get(position).getLetra().hashCode();
    }

    @Override
    public View getView(int position, View lineaView, ViewGroup parent) {
        if (lineaView == null){
            lineaView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_linea, parent, false);
        }
        bindLineaItem(lineaView, lineas.get(position));
        return lineaView;
    }

    public void notifiedDataSetChanged(){
        throw new RuntimeException("Stub!");
    }

    public void bindLineaItem(final View root, final Linea linea){
        root.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                Intent intent = new Intent(root.getContext(),
                        LineaLetraDetailsActivity.class);
                intent.putExtra("linea", new Gson().toJson(linea));
                root.getContext().startActivity(intent);
            }
        });
        ImageView lineaIv = root.findViewById(R.id.imagenLinea);
        TextView lineaTv = root.findViewById(R.id.letra);
        TextView estadoTv = root.findViewById(R.id.estado);
        TextView detalleTv = root.findViewById(R.id.detalle);


        lineaTv.setText(linea.getLetra());
        estadoTv.setText(linea.getEstado());
        detalleTv.setText(linea.getDetalle());
        lineaIv.setImageResource(linea.getImageResourceId());

    }
}
