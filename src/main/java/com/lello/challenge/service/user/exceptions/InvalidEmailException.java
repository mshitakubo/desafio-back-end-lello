package com.lello.challenge.service.user.exceptions;

public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException(String msg){
        super(msg);
    }
}
