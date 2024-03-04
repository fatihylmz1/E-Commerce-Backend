package com.ecommerce.exception;

import org.springframework.http.HttpStatus;

public class RoleException extends RuntimeException{
    private HttpStatus status;

    public RoleException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
