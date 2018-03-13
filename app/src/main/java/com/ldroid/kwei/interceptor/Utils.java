package com.ldroid.kwei.interceptor;

import okhttp3.HttpUrl;


class Utils {

    private Utils() {
        throw new IllegalStateException("do not instantiation me");
    }

    static HttpUrl checkUrl(String url) {
        if(null == url){
            return null ;
        }
        HttpUrl parseUrl = HttpUrl.parse(url);
        if (null == parseUrl) {
            throw new NullPointerException("The url [" + url + "] Not well-formed");
        } else {
            return parseUrl;
        }
    }
}
