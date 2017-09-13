package com.turo.boot.client;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

import java.time.Instant;

public class InstantAdapter {
    @FromJson
    public Instant fromJson(String value) {
        return Instant.parse(value);
    }
}