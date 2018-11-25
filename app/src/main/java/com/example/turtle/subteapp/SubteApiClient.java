package com.example.turtle.subteapp;

import java.io.IOException;

import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubteApiClient {
    private static Object httpClient;

    public static SubteApiInterface getClient(){
        return new Retrofit.Builder()
                .baseUrl("https://api.myjson.com/bins/re8fi/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(getHttpClient())
                .build()
                .create(SubteApiInterface.class);
    }

    public static OkHttpClient getHttpClient() {
        Authenticator proxyAuthenticator = new Authenticator() {
            @Override
            public Request authenticate(Route route, Response response) throws IOException {
                String credential = Credentials.basic("jano.zeballos", "40641702");
                return response.request().newBuilder()
                        .header("Proxy-Authorization", credential)
                        .build();
            }
        };

        OkHttpClient httpClient = new OkHttpClient.Builder().build();
        return httpClient;
    }
}
