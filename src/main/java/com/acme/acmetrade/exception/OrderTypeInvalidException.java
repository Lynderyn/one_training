package com.acme.acmetrade.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OrderTypeInvalidException extends RuntimeException {
    public OrderTypeInvalidException(String message) {
        super(message);
    }
}