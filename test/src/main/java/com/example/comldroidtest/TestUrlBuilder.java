package com.example.comldroidtest;

import com.example.comldroidtest.login.LoginService;
import com.ldroid.kwei.retrofit.UrlBuilder;


public class TestUrlBuilder extends UrlBuilder{

    @Override
    public String getUrlHeaderName() {
        return LoginService.MAIN_DOMAIN;
    }


    @Override
    public String getBaseUrl() {
        return "http://172.16.180.103:7008/easd/";
    }
}
