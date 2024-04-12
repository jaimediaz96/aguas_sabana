package com.asb.back_micro_route_business_service.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GenericException  extends  RuntimeException {
    private final String message;
    private final HttpStatus status;
    

    public GenericException(String message, HttpStatus status) {
        super(message);
        this.message = message;
        this.status = status;
    }
}