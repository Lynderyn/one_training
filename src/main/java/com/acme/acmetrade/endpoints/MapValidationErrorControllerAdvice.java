package com.acme.acmetrade.endpoints;

import com.acme.acmetrade.exception.MapValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class MapValidationErrorControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler({MapValidationException.class})
    protected ResponseEntity<Map<String, String>> handleConflict(MapValidationException ex) {
        return new ResponseEntity(ex.getErrors(), HttpStatus.BAD_REQUEST);
    }
}
