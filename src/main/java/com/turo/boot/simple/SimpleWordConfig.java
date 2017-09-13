package com.turo.boot.simple;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("simple")
@Profile("!number")
public class SimpleWordConfig {
    private String variable;
    private String secret;

    public String getVariable() {
        return variable;
    }

    public void setVariable(final String variable) {
        this.variable = variable;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(final String secret) {
        this.secret = secret;
    }
}
