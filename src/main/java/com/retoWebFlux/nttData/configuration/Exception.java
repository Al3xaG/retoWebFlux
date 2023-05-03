package com.retoWebFlux.nttData.configuration;

import com.retoWebFlux.nttData.exceptions.NotFoundException;
import com.retoWebFlux.nttData.exceptions.TransactionException;
import com.retoWebFlux.nttData.exceptions.error.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@ControllerAdvice(annotations = RestController.class)
public class Exception {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> notFoundException(NotFoundException e){
        return new ResponseEntity<>(new ErrorResponse(e.getLocalizedMessage(), HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TransactionException.class)
    public ResponseEntity<Object> transactionException(TransactionException e){
        return new ResponseEntity<>(new ErrorResponse(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }
}
