package com.ldroid.kwei.retrofit;

import android.text.TextUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class RetrofitUrlManager {

    private static final String DOMAIN_NAME = "Domain-Name";
    public static final String DOMAIN_NAME_HEADER = DOMAIN_NAME + ": ";
    private final Map<String, HttpUrl> mDomainNameHub = new HashMap<>();
    private final Interceptor mInterceptor;


    private RetrofitUrlManager() {
        this.mInterceptor = new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                return chain.proceed(processRequest(chain.request()));
            }
        };
    }

    private static class RetrofitUrlManagerHolder {
        private static final RetrofitUrlManager INSTANCE = new RetrofitUrlManager();
    }

    public static final RetrofitUrlManager getInstance() {
        return RetrofitUrlManagerHolder.INSTANCE;
    }

    public OkHttpClient.Builder with(OkHttpClient.Builder builder) {
        return builder
                .addInterceptor(mInterceptor);
    }


    public Request processRequest(Request request) {
        Request.Builder newBuilder = request.newBuilder();
        HttpUrl httpUrl = null;
        String domainName = obtainDomainNameFromHeaders(request);
        if (!TextUtils.isEmpty(domainName)) {
            httpUrl = fetchDomain(domainName);
            newBuilder.removeHeader(DOMAIN_NAME);
        }
        if (null != httpUrl) {
            HttpUrl newUrl = parseUrl(httpUrl, request.url());
            return newBuilder
                    .url(newUrl)
                    .build();
        }
        return newBuilder.build();

    }

    public HttpUrl parseUrl(HttpUrl domainUrl, HttpUrl url) {
        if (null == domainUrl) return url;
        return url.newBuilder()
                .scheme(domainUrl.scheme())
                .host(domainUrl.host())
                .port(domainUrl.port())
                .build();
    }


    public void putDomain(String domainName, String domainUrl) {
        synchronized (mDomainNameHub) {
            mDomainNameHub.put(domainName, Utils.checkUrl(domainUrl));
        }
    }


    public HttpUrl fetchDomain(String domainName) {
        return mDomainNameHub.get(domainName);
    }

    public void removeDomain(String domainName) {
        synchronized (mDomainNameHub) {
            mDomainNameHub.remove(domainName);
        }
    }

    public void clearAllDomain() {
        mDomainNameHub.clear();
    }



    private String obtainDomainNameFromHeaders(Request request) {
        List<String> headers = request.headers(DOMAIN_NAME);
        if (headers == null || headers.size() == 0)
            return null;
        if (headers.size() > 1)
            throw new IllegalArgumentException("Only one Domain-Name in the headers");
        return request.header(DOMAIN_NAME);
    }

}
