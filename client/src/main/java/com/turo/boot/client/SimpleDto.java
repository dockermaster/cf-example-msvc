package com.turo.boot.client;

public class SimpleDto {
    private final String variable;
    private final String secret;
    private final String timestamp;

    public SimpleDto(final String variable, final String secret, final String timestamp) {
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

    @Override
    public String toString() {
        return "SimpleDto{" +
               "variable='" + variable + '\'' +
               ", secret='" + secret + '\'' +
               ", timestamp='" + timestamp + '\'' +
               '}';
    }
}
