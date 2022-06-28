package com.challenge.itau.movies.service;

import com.challenge.itau.movies.entity.Movie;

import java.util.List;

public interface MovieService {

    Movie create(Movie movie);
    List<Movie> getAll();
    void delete(Long id);
    Movie getById(Long id);
}
