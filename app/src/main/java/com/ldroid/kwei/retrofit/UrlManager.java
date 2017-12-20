package com.ldroid.kwei.retrofit;


import java.util.HashMap;
import java.util.Map;

import okhttp3.HttpUrl;

public class UrlManager {

    public static final String DOMAIN_NAME = "Domain-Name";
    public static final String DOMAIN_NAME_HEADER = DOMAIN_NAME + ": ";
    private static final String BASE_DOMAIN_NAME = "Base-Domain-Name";
    private final Map<String, HttpUrl> urlMap;
    private static final UrlManager INSTANCE = new UrlManager();

    private UrlManager() {
        urlMap = new HashMap<>();
    }

    public static UrlManager getInstance() {
        return INSTANCE;
    }

    public void putDomain(String domainName, String domainUrl) {
        synchronized (urlMap) {
            urlMap.put(domainName, Utils.checkUrl(domainUrl));
        }
    }

    public HttpUrl getDomain(String domainName) {
        return urlMap.get(domainName);
    }


    public void putBaseDomain(String domainUrl) {
        synchronized (urlMap) {
            urlMap.put(BASE_DOMAIN_NAME, Utils.checkUrl(domainUrl));
        }
    }

    public HttpUrl getBaseDomain() {
        return urlMap.get(BASE_DOMAIN_NAME);
    }

}
