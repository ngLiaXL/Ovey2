package com.ldroid.kwei.retrofit;

import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    public static final String API_BASE_URL = "http://dmc.eascs.com/easd/";
    public static final ServiceGenerator INSTANCE = new ServiceGenerator();

    private OkHttpClient.Builder okHttpClientBuilder;
    private Retrofit retrofit;
    private Map<String, Object> serviceMap;


    private ServiceGenerator() {
        serviceMap = new HashMap<>();
        initRetrofit(initOkHttpClientBuilder().build());
    }

    private OkHttpClient.Builder initOkHttpClientBuilder() {
        okHttpClientBuilder = new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClientBuilder.addInterceptor(logging);
        return okHttpClientBuilder;
    }

    private Retrofit initRetrofit(OkHttpClient client) {
        retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(API_BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }


    public <S> S getService(Class<S> serviceClass) {
        if (serviceMap.containsKey(serviceClass.getName())) {
            return (S) serviceMap.get(serviceClass.getName());
        } else {
            Object obj = retrofit.create(serviceClass);
            serviceMap.put(serviceClass.getName(), obj);
            return (S) obj;
        }
    }


}