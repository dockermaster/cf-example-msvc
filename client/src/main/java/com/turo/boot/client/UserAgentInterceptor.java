package com.turo.boot.client;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class UserAgentInterceptor implements Interceptor {
 
    private final String userAgent;
 
    public UserAgentInterceptor(String userAgent) {
        this.userAgent = userAgent;
    }
 
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originRequest = chain.request();
        Request requestWithUserAgent = originRequest.newBuilder()
                                                    .header("User-Agent", userAgent)
                                                    .build();
        return chain.proceed(requestWithUserAgent);
    }
}