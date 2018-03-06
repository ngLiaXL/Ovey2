package com.ldroid.kwei.retrofit;


import android.support.annotation.NonNull;

public class UrlProvider {

    private static final UrlProvider INSTANCE = new UrlProvider();

    private UrlBuilder urlBuilder;

    private UrlProvider() {
    }


    public static void init(@NonNull UrlBuilder urlBuilder) {
        INSTANCE.urlBuilder = urlBuilder;
    }

    public static UrlProvider getInstance() {
        return INSTANCE;
    }

    @NonNull
    public UrlBuilder providUrl() {
        return urlBuilder;
    }

    public void put(String key, String value) {
        urlBuilder.put(key, value);
    }

    public String remove(String key) {
        return urlBuilder.remove(key);
    }

}
