package com.turo.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @SuppressWarnings("SameReturnValue")
    @GetMapping("/health")
    public String doGet() {
        return "OK";
    }
}
