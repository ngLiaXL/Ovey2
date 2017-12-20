package com.ldroid.kwei.retrofit;


import java.util.HashMap;

public abstract class UrlBuilder extends HashMap<String, String> {

    public abstract String getHeaderKey();

    public abstract String getBaseUrl();
}
