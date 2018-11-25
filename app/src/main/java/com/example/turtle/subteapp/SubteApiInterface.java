package com.example.turtle.subteapp;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface SubteApiInterface {
    @GET("/")
    public Call<List<Linea>> getLineas();
}
