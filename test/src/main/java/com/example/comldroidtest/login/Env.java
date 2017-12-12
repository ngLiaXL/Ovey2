package com.example.comldroidtest.login;


import com.ldroid.kwei.BuildConfig;

public enum Env {


    /**
     * 开发环境
     * http://172.16.180.129:7001/easd/ 崔征
     * http://172.16.180.103:7008/easd/ 姜超
     */
    debug("http://main.eascs.com/easd/",
            "http://172.29.12.183:7001/eaoa/"),

    /**
     * 生产环境
     */
    release("http://main.eascs.com/easd/",
            "http://oa.eascs.com/eaoa/");


    private static final Env ENV;

    private final String mainUrl;
    private final String otherUrl;


    static {
        ENV = Env.valueOf(BuildConfig.BUILD_TYPE);
    }


    Env(String mainUrl, String otherUrl) {
        this.mainUrl = mainUrl;
        this.otherUrl = otherUrl;
    }


    public static Env get() {
        return ENV;
    }

    public String getMainUrl() {
        return mainUrl;
    }

    public String getOtherUrl() {
        return otherUrl;
    }

}