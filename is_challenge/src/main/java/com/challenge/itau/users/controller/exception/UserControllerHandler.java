package com.challenge.itau.users.controller.exception;

import com.challenge.itau.users.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserControllerHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> userNotFoundException(UserNotFoundException err) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(err.getMessage());
    }
}
