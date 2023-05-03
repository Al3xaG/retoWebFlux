package com.retoWebFlux.nttData.exceptions;

public class TransactionException extends RuntimeException {
    public TransactionException(String msg) {
        super(msg);
    }
}
