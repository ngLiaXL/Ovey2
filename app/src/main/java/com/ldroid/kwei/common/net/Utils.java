package com.ldroid.kwei.common.net;

import okhttp3.HttpUrl;


class Utils {

    private Utils() {
        throw new IllegalStateException("do not instantiation me");
    }

    static HttpUrl checkUrl(String url) {
        HttpUrl parseUrl = HttpUrl.parse(url);
        if (null == parseUrl) {
            throw new NullPointerException("The url [" + url + "] Not well-formed");
        } else {
            return parseUrl;
        }
    }
}
