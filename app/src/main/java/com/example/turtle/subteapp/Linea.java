package com.example.turtle.subteapp;

import java.util.List;

public class Linea {
    private List<String> estaciones;
    private int imageResourceId;
    private String letra;
    private String estado;
    private String detalle;

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public List<String> getEstaciones() {
        return estaciones;
    }

    public void setEstaciones(List<String> estaciones) {
        this.estaciones = estaciones;
    }
}
