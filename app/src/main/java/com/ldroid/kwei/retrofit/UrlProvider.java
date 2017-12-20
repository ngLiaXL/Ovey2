package com.ldroid.kwei.retrofit;


import android.support.annotation.NonNull;

public class UrlProvider {

    private static final UrlProvider INSTANCE = new UrlProvider();

    private UrlBuilder urlBuilder;

    private UrlProvider() {
    }

    public static UrlProvider getUrlPorvider() {
        return INSTANCE;
    }

    public UrlBuilder getUrlBuilder() {
        return urlBuilder;
    }

    public void setUrlBuilder(@NonNull UrlBuilder urlBuilder) {
        this.urlBuilder = urlBuilder;
    }

    public void put(String key, String value) {
        urlBuilder.put(key, value);
    }

}
