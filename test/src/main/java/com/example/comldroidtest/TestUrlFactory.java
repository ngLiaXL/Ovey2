package com.example.comldroidtest;

import com.ldroid.kwei.retrofit.BaseUrlFactory;


public class TestUrlFactory extends BaseUrlFactory {

    public static final String MAIN_DOMAIN = "key";

    public interface UrlKeys {
        String SD = "SD";
        String GD = "GD";
    }

    public TestUrlFactory() {
        put(UrlKeys.SD, "https://api.douban.com/");
    }

    @Override
    public String getUrlHeaderName() {
        return MAIN_DOMAIN;
    }


    @Override
    public String getBaseUrl() {
        return "https://api.douban.com/";
    }

}
