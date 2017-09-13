package com.turo.boot.controller;

import com.turo.boot.controller.exceptions.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.concurrent.CompletionException;

@RestControllerAdvice
public class ApiExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = BadRequestException.class)
    public String handleBadRequestException(final BadRequestException e) {
        logger.warn("handleBadRequestException {}", e);
        return e.getMessage();
    }

    @ExceptionHandler(value = CompletionException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public String handleExceptionCompletionException(final CompletionException e) {
        logger.warn("handleExceptionCompletionException {}", e.getCause().getMessage());
        return e.getCause().getMessage();
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleUnhandledException(final Exception e) {
        MDC.put("unhandled_exception", e.getClass().toString());
        logger.error("handleException", e);
        MDC.remove("unhandled_exception");
        return e.getMessage();
    }
}
