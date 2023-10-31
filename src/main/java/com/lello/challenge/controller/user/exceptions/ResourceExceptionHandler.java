package com.lello.challenge.controller.user.exceptions;

import com.lello.challenge.service.user.exceptions.EntityNotFoundException;
import com.lello.challenge.service.user.exceptions.InvalidDescriptionException;
import com.lello.challenge.service.user.exceptions.InvalidEmailException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(EntityNotFoundException e, HttpServletRequest httpServletRequest) {
        StandardError error = new StandardError(Instant.now(),
                HttpStatus.NOT_FOUND.value(), "Resource not found", e.getMessage(), httpServletRequest.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(InvalidEmailException.class)
    public ResponseEntity<StandardError> invalidEmail(InvalidEmailException e, HttpServletRequest httpServletRequest) {
        StandardError error = new StandardError(Instant.now(),
                HttpStatus.BAD_REQUEST.value(), "invalid format email", e.getMessage(), httpServletRequest.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(InvalidDescriptionException.class)
    public ResponseEntity<StandardError> invalidEmail(InvalidDescriptionException e, HttpServletRequest httpServletRequest) {
        StandardError error = new StandardError(Instant.now(),
                HttpStatus.BAD_REQUEST.value(), "invalid format description", e.getMessage(), httpServletRequest.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
