package com.acme.acmetrade.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StockQuoteIDException extends RuntimeException {
    public StockQuoteIDException(String message) { super(message);
    }
}
