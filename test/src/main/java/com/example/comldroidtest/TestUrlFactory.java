package com.example.comldroidtest;

import com.example.comldroidtest.login.LoginService;
import com.ldroid.kwei.retrofit.BaseUrlFactory;


public class TestUrlFactory extends BaseUrlFactory {


    public TestUrlFactory() {
        put("abc", "http://main.dev.eascs.com/easd/");
    }

    @Override
    public String getUrlHeaderName() {
        return LoginService.MAIN_DOMAIN;
    }


    @Override
    public String getBaseUrl() {
        return "http://main.dev.eascs.com/easd/";
    }

}
