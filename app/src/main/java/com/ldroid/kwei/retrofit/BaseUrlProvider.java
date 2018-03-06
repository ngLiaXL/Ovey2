package com.ldroid.kwei.retrofit;


import android.support.annotation.NonNull;

public class BaseUrlProvider {

    @NonNull
    private static BaseUrlBuilder sUrlBuilder;

    private BaseUrlProvider() {
    }


    public static void setUrlBuilder(BaseUrlBuilder urlBuilder) {
        sUrlBuilder = urlBuilder;
    }

    public static BaseUrlBuilder getUrlBuilder() {
        return sUrlBuilder;
    }

    public static void put(String key, String value) {
        sUrlBuilder.put(key, value);
    }

    public static String remove(String key) {
        return sUrlBuilder.remove(key);
    }

}
