package com.retoWebFlux.nttData.exceptions.error;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    private String message;
    private LocalDateTime date;
    private HttpStatus status;

    public ErrorResponse(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
        date = LocalDateTime.now();
    }
}
