package com.challenge.itau.movies.controller.exception;

import com.challenge.itau.movies.exception.MovieNotFoundException;
import com.challenge.itau.movies.exception.CommentNotFoundException;
import com.challenge.itau.movies.exception.ScoreNotFoundException;
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

//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
//
//        System.out.println("TESTE");
//        Map<String, Object> body = new LinkedHashMap<>();
//        body.put("timestamp", System.currentTimeMillis());
//        body.put("status", status.value());
//        List<String> errors = ex.getBindingResult()
//                .getFieldErrors()
//                .stream()
//                .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
//        body.put("errors", errors);
//        return new ResponseEntity<Object>(body, status);
//    }

}
