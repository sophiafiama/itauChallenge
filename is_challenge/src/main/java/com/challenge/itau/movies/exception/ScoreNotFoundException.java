package com.challenge.itau.movies.exception;

public class ScoreNotFoundException extends RuntimeException{
    public ScoreNotFoundException(String messege){
        super(messege);
    }
}
