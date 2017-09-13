package com.turo.boot.client;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class Test {
    public static void main(final String[] args) throws Exception {
        final String baseUrl = "http://localhost:8080";

        CfExampleApi client = CfExampleClientFactory.create(baseUrl);

        client.getConfig().enqueue(new Callback<SimpleDto>() {
            @Override
            public void onResponse(final Call<SimpleDto> call, final Response<SimpleDto> response) {
                System.out.println("Response: " + response.body());
            }

            @Override
            public void onFailure(final Call<SimpleDto> call, final Throwable t) {
                t.printStackTrace();
            }
        });
        Thread.sleep(1000);
        client.getConfig().enqueue(new Callback<SimpleDto>() {
            @Override
            public void onResponse(final Call<SimpleDto> call, final Response<SimpleDto> response) {
                System.out.println("Response: " + response.body());
            }

            @Override
            public void onFailure(final Call<SimpleDto> call, final Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
