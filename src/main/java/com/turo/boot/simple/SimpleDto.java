package com.turo.boot.simple;

import java.time.Instant;

public class SimpleDto {
    private final String variable;
    private final String secret;
    private final Instant timestamp;

    public SimpleDto(final String variable, final String secret, final Instant timestamp) {
        this.variable = variable;
        this.secret = secret;
        this.timestamp = timestamp;
    }

    public String getVariable() {
        return variable;
    }

    public String getSecret() {
        return secret;
    }

    public String getTimestamp() {
        return timestamp.toString();
    }
}
