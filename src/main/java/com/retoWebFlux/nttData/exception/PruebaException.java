package com.retoWebFlux.nttData.exception;

import org.springframework.http.HttpStatus;

public class PruebaException extends RuntimeException{
    private HttpStatus httpStatus;

    public PruebaException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
