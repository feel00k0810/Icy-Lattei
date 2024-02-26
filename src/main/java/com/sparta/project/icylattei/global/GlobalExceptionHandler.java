package com.sparta.project.icylattei.global;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({IllegalArgumentException.class, DuplicateKeyException.class})
    public ResponseEntity<String> handleException(Exception e ){
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST.value())
            .body(e.getMessage());
    }
}
