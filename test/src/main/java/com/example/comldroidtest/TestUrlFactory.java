package com.example.comldroidtest;

import com.ldroid.kwei.retrofit.BaseUrlFactory;


public class TestUrlFactory extends BaseUrlFactory {

    public static final String MAIN_DOMAIN = "key";

    public interface UrlKeys {
        String SD = "SD";
        String HTTPS = "HTTPS" ;
    }

    public TestUrlFactory() {
        put(UrlKeys.HTTPS, "https://kyfw.12306.cn/");
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
