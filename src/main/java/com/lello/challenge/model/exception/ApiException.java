package com.lello.challenge.model.exception;


import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final String message;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public ApiException(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

}
