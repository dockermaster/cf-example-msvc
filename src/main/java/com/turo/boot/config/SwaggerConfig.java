package com.turo.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .genericModelSubstitutes(ResponseEntity.class, CompletableFuture.class);
    }

    private ApiInfo apiInfo() {
        final ApiInfo apiInfo = new ApiInfo(
                "cf-example-msvc REST API",
                "A simple example of a REST API.",
                "API TOS",
                "Terms of service",
                new Contact("Turo Engineering", "https://github.com/relayrides/cf-example-msvc", "engineering+cf-example-msvc@turo.com"),
                "License of API",
                "API license URL",
                Collections.emptyList());
        return apiInfo;
    }
}
