package com.example.comldroidtest;

import com.example.comldroidtest.login.LoginService;
import com.ldroid.kwei.retrofit.BaseUrlBuilder;


public class TestUrlBuilder extends BaseUrlBuilder {


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
