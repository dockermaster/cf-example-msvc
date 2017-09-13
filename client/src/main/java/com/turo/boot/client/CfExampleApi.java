package com.turo.boot.client;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface CfExampleApi {
    @GET("/config")
    Call<SimpleDto> getConfig();

    @GET("/config-async")
    Call<SimpleDto> getConfigAsync(@Query("delaySeconds") long delaySeconds);
}
