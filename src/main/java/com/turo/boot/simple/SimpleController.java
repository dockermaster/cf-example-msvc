package com.turo.boot.simple;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class SimpleController {

    private final SimpleService service;

    public SimpleController(final SimpleService service) {
        this.service = service;
    }

    @ApiOperation(value = "Simple get of configuration values",
                  notes = "These are notes. The can be long.  \nI guess they can have newlines",
                  tags = {"api", "config"})
    @GetMapping("/config")
    public SimpleDto doGet() {
        return service.get();
    }

    @ApiOperation(value = "Async get of configuration values",
                  notes = "These are notes. The can be long.  \nI guess they can have newlines",
                  tags = {"api", "config", "async"})
    @GetMapping("/config-async")
    public CompletableFuture<SimpleDto> doGetAsync(@ApiParam("Specify the asynchronous delay in seconds")
                                                   @RequestParam(defaultValue = "5") final long delaySeconds) {
        return service.getAsync(delaySeconds);
    }
}
