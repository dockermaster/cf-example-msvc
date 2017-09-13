package com.turo.boot.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.concurrent.CompletableFuture;

@Service
@Profile("number")
public class SimpleNumberService implements SimpleService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final SimpleNumberConfig config;

    @Autowired
    public SimpleNumberService(final SimpleNumberConfig config) {
        this.config = config;
    }

    @Override
    public SimpleDto get() {
        final SimpleDto simpleDto = new SimpleDto("Var:" + config.getVariable(), "Secret:" + config.getSecret(), Instant.now());
        logger.info("complete request: {}", simpleDto);
        return simpleDto;
    }

    @Override
    @Async
    public CompletableFuture<SimpleDto> getAsync(final long delaySeconds) {
        return CompletableFuture.supplyAsync(() -> {
            logger.info("starting number request: {}s delay", delaySeconds);
            try {
                Thread.sleep(delaySeconds * 1000);
            } catch (final InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return get();
        });
    }
}
