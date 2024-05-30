package com.siigroup.thales.devtest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionHandlerController {

    private final Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler(HttpStatusCodeException.class)
    public ResponseEntity<String> httpStatusCodeException(HttpStatusCodeException ex){
        logger.error(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), ex.getStatusCode());
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> noSuchElementException(NoSuchElementException ex){
        logger.error(ex.getMessage());
        return ResponseEntity.internalServerError().body(ex.getMessage());
    }
}
