package com.turo.boot.client;

import com.squareup.moshi.Moshi;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

import java.util.concurrent.TimeUnit;

public class CfExampleClientFactory {
    private static String userAgent = "cf-example-client/1.0 (Turo)";

    public static CfExampleApi create(String baseUrl) {
        final Retrofit retrofit = new Retrofit.Builder()
                .client(createOkHttpClient())
                .baseUrl(baseUrl)
                .addConverterFactory(MoshiConverterFactory.create(createMoshi()))
                .build();
        return retrofit.create(CfExampleApi.class);
    }

    static Moshi createMoshi() {
        return new Moshi.Builder().add(new InstantAdapter())
                .add(new InstantAdapter())
                .add(new BigDecimalAdapter())
                .build();
    }

    static OkHttpClient createOkHttpClient() {

        final OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(25, TimeUnit.SECONDS)
                .readTimeout(25, TimeUnit.SECONDS)
                .writeTimeout(25, TimeUnit.SECONDS)
                .followRedirects(false)
                .followSslRedirects(true)
                .addInterceptor(new UserAgentInterceptor(userAgent));
        return builder.build();
    }
}
