package com.acme.acmetrade.exception;

import java.util.Map;

public class MapValidationException extends RuntimeException {

    private Map<String, String> errors;

    public MapValidationException(String message, Map<String, String> errors) {
        super(message);
        this.errors = errors;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}
