package com.retoWebFlux.nttData.exception;

import org.springframework.http.HttpStatus;

public class ValidationException extends PruebaException{

    public ValidationException(String validationMessage){
        super(HttpStatus.PRECONDITION_FAILED, validationMessage);
    }
}
