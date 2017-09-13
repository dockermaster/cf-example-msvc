package com.turo.boot.simple;

import java.util.concurrent.CompletableFuture;

public interface SimpleService {
    SimpleDto get();
    CompletableFuture<SimpleDto> getAsync(long delaySeconds);
}
