package com.challenge.itau.movies.exception;

public class CommentNotFoundException extends RuntimeException {
    public CommentNotFoundException(String messege) {
        super(messege);
    }
}
