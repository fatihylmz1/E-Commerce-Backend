package com.ecommerce.exception;

import org.springframework.http.HttpStatus;

public class AddressException extends RuntimeException{
    private HttpStatus status;

    public AddressException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
