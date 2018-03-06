package com.ldroid.kwei.retrofit;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static final ServiceGenerator INSTANCE = new ServiceGenerator();

    private Retrofit retrofit;
    private final Map<String, Object> serviceMap;

    public static ServiceGenerator getInstance() {
        return INSTANCE;
    }

    private ServiceGenerator() {
        serviceMap = new HashMap<>();
        initRetrofit();
    }


    private Retrofit initRetrofit() {
        retrofit = new Retrofit.Builder()
                .client(OkHttpClientProvider.createClient())
                .baseUrl(BaseUrlProvider.getUrlBuilder().getBaseUrl())
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