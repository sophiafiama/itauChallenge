package com.challenge.itau.movies.service;

import com.challenge.itau.movies.entity.Score;

import java.util.List;

public interface ScoreService {
    Score create(Score score);
    void delete(Long id);
    Score get(Long id);
    List<Score> getAll();
}
