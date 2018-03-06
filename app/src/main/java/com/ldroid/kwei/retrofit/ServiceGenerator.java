package com.ldroid.kwei.retrofit;

import com.ldroid.kwei.App;
import com.ldroid.kwei.cookie.PersistentCookieJar;
import com.ldroid.kwei.cookie.cache.SetCookieCache;
import com.ldroid.kwei.cookie.persistence.SharedPrefsCookiePersistor;
import com.ldroid.kwei.interceptor.HttpLoggingInterceptor;
import com.ldroid.kwei.interceptor.UrlInterceptor;

import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
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
        initRetrofit(defaultClient().build());
    }


    private OkHttpClient.Builder defaultClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(logging);
        builder.addInterceptor(new UrlInterceptor(UrlProvider.getInstance().providUrl()));
        builder.cookieJar(new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(App.INSTANCE)));
        return builder;
    }

    private Retrofit initRetrofit(OkHttpClient client) {
        retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(UrlProvider.getInstance().providUrl().getBaseUrl())
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