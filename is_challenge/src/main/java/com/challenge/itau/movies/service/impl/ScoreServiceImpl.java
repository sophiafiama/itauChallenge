package com.challenge.itau.movies.service.impl;

import com.challenge.itau.movies.entity.Movie;
import com.challenge.itau.movies.exception.MovieNotFoundException;
import com.challenge.itau.movies.repository.MovieRepository;
import com.challenge.itau.movies.repository.ScoreRepository;
import com.challenge.itau.users.exception.UserNotFoundException;
import com.challenge.itau.users.repository.UserRepository;
import com.challenge.itau.movies.entity.Score;
import com.challenge.itau.movies.exception.ScoreNotFoundException;
import com.challenge.itau.movies.service.ScoreService;
import com.challenge.itau.users.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ScoreServiceImpl implements ScoreService {

    private final ScoreRepository scoreRepository;
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    @Override
    public Score create(Score score) {
        score = updatingUserAndMovie(score);
        return scoreRepository.save(score);
    }

    @Override
    public void delete(Long id) {
        scoreRepository
                .findById(id).orElseThrow(()->
                        new ScoreNotFoundException("You can not delete an score with id " + id + " because this id does not exists!"));

    }

    @Override
    public Score get(Long id) {
        return scoreRepository.findById(id).orElseThrow(()->new ScoreNotFoundException("Score with id  "+  id +  " not found!"));
    }

    @Override
    public List<Score> getAll() {
        return scoreRepository.findAll();
    }

    private Score updatingUserAndMovie(Score score) {
        User userToBeUpdated = userRepository.findById(score
                .getUser()
                .getId()).orElseThrow( () -> new UserNotFoundException("User with id " + score.getUser().getId() + " not found!"));

        Movie movieToBeUpdated = movieRepository.findById(score
                .getMovie()
                .getId()).orElseThrow( () -> new MovieNotFoundException("Movie with id " + score.getMovie().getId() + " not found!"));

        score.setUser(userToBeUpdated);
        score.setMovie(movieToBeUpdated);

        movieToBeUpdated.getScores().add(score);
        userToBeUpdated.getScores().add(score);
        userToBeUpdated.addingActions();
        userToBeUpdated.permissionRole();

        userRepository.saveAndFlush(userToBeUpdated);
        movieRepository.saveAndFlush(movieToBeUpdated);
        return score;
    }
}
