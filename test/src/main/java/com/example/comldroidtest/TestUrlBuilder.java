package com.example.comldroidtest;

import com.example.comldroidtest.login.LoginService;
import com.ldroid.kwei.retrofit.UrlBuilder;


public class TestUrlBuilder extends UrlBuilder{


    public TestUrlBuilder() {
        put("abc", "http://dmc.eascs.com/easd/");
    }

    @Override
    public String getUrlHeaderName() {
        return LoginService.MAIN_DOMAIN;
    }


    @Override
    public String getBaseUrl() {
        return "http://im.eascs.com/";
    }

}
