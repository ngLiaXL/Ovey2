package com.ldroid.kwei.retrofit;


import java.util.HashMap;

public abstract class UrlBuilder extends HashMap<String, String> {

    public abstract String getUrlHeaderName();

    public abstract String getBaseUrl();
}
