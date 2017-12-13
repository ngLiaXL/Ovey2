package com.ldroid.kwei.retrofit;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCreator {

    public static final RetrofitCreator INSTANCE = new RetrofitCreator();

    private OkHttpClient httpClient;

    private RetrofitCreator() {
    }

    public Retrofit getInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dmc.eascs.com/easd/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client())
                .build();
        return retrofit;
    }

    private OkHttpClient client() {
        if (httpClient == null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClient = new OkHttpClient.Builder().addInterceptor(logging).build();
        }
        return httpClient;
    }
}
