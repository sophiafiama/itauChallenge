package com.is_challenge.is_challenge.apiStreaming.controller.exception;

import com.is_challenge.is_challenge.apiStreaming.exception.CommentNotFoundException;
import com.is_challenge.is_challenge.apiStreaming.exception.MovieNotFoundException;
import com.is_challenge.is_challenge.apiStreaming.exception.ScoreNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ControllerHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<String> movieNotFoundException(MovieNotFoundException err) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(err.getMessage());
    }

    @ExceptionHandler(CommentNotFoundException.class)
    public ResponseEntity<String> commentNotFoundException(CommentNotFoundException err) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(err.getMessage());
    }

    @ExceptionHandler(ScoreNotFoundException.class)
    public ResponseEntity<String> scoreNotFoundException(ScoreNotFoundException err) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(err.getMessage());
    }




}
