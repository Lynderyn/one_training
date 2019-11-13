package com.acme.acmetrade.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MarketSectorIDException extends RuntimeException {
    public MarketSectorIDException(String message) {
        super(message);
    }
}
