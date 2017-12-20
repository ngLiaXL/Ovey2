package com.ldroid.kwei.interceptor;

import android.text.TextUtils;

import com.ldroid.kwei.retrofit.UrlManager;

import java.io.IOException;
import java.util.List;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static com.ldroid.kwei.retrofit.UrlManager.DOMAIN_NAME;

public class HeaderUrlInterceptor implements Interceptor {

    private final UrlManager urlBuilder;

    public HeaderUrlInterceptor(UrlManager urlBuilder) {
        this.urlBuilder = urlBuilder;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        return chain.proceed(processRequest(chain.request()));
    }

    private Request processRequest(Request request) {
        Request.Builder newBuilder = request.newBuilder();
        HttpUrl httpUrl;
        String domainName = obtainDomainNameFromHeaders(request);
        if (!TextUtils.isEmpty(domainName)) {
            httpUrl = getDomain(domainName);
            newBuilder.removeHeader(DOMAIN_NAME);
        } else {
            httpUrl = getGlobalDomain();
        }
        if (null != httpUrl) {
            HttpUrl newUrl = parseUrl(httpUrl, request.url());
            return newBuilder
                    .url(newUrl)
                    .build();
        }
        return newBuilder.build();
    }


    private HttpUrl parseUrl(HttpUrl domainUrl, HttpUrl url) {
        if (null == domainUrl) return url;
        return url.newBuilder()
                .scheme(domainUrl.scheme())
                .host(domainUrl.host())
                .port(domainUrl.port())
                .build();
    }


    private String obtainDomainNameFromHeaders(Request request) {
        List<String> headers = request.headers(DOMAIN_NAME);
        if (headers == null || headers.size() == 0)
            return null;
        if (headers.size() > 1)
            throw new IllegalArgumentException("Only one Domain-Name in the headers");
        return request.header(DOMAIN_NAME);
    }


    public HttpUrl getDomain(String domainName) {
        return urlBuilder.getDomain(domainName);
    }

    public HttpUrl getGlobalDomain() {
        return urlBuilder.getBaseDomain();
    }
}
