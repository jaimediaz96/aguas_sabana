package com.asb.back_micro_route_business_service.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class GenericException extends  RuntimeException {
    private final String message;
    private final HttpStatus status;

    public GenericException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}
