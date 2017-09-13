package com.turo.boot.simple;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("simple-number")
@Profile("number")
public class SimpleNumberConfig {
    private final double variable;
    private final double secret;

    public SimpleNumberConfig(final double variable, final double secret) {
        this.variable = variable;
        this.secret = secret;
    }

    public double getVariable() {
        return variable;
    }

    public double getSecret() {
        return secret;
    }
}
