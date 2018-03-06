package com.example.comldroidtest;

import com.ldroid.kwei.App;
import com.ldroid.kwei.cookie.PersistentCookieJar;
import com.ldroid.kwei.cookie.cache.SetCookieCache;
import com.ldroid.kwei.cookie.persistence.SharedPrefsCookiePersistor;
import com.ldroid.kwei.interceptor.HttpLoggingInterceptor;
import com.ldroid.kwei.interceptor.BaseUrlInterceptor;
import com.ldroid.kwei.retrofit.OkHttpClientFactory;
import com.ldroid.kwei.retrofit.BaseUrlProvider;

import okhttp3.OkHttpClient;


public class DefaultOkHttpClientFactory implements OkHttpClientFactory {

    @Override
    public OkHttpClient createNewNetworkModuleClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .addInterceptor(logging)
                .addInterceptor(new BaseUrlInterceptor(BaseUrlProvider.getUrlBuilder()))
                .cookieJar(new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(App.INSTANCE))).build();
    }
}
