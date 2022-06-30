package com.challenge.itau.movies.service;

import com.challenge.itau.movies.entity.Answer;

public interface AnswerService {
    Answer create(Answer answer);
    void delete(Long id);
}
