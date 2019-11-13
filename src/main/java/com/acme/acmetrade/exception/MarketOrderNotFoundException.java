package com.acme.acmetrade.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MarketOrderNotFoundException extends RuntimeException {
    public MarketOrderNotFoundException(String message) {
        super(message);
    }
}