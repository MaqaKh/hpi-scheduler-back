package com.communitynotes.usecase.ad;

import org.jsoup.HttpStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(HttpStatusException.class)
    public ResponseEntity<String> handleHttpStatusException(HttpStatusException ex) {
        if (ex.getStatusCode() == 404) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found: " + ex.getUrl());
        }
        return ResponseEntity.status(HttpStatus.valueOf(ex.getStatusCode())).body(ex.getMessage());
    }
} 