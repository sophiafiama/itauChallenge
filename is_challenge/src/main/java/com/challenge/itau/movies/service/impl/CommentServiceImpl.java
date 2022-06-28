package com.challenge.itau.movies.service.impl;

import com.challenge.itau.movies.entity.Movie;
import com.challenge.itau.movies.exception.CommentNotFoundException;
import com.challenge.itau.movies.exception.MovieNotFoundException;
import com.challenge.itau.movies.repository.CommentRepository;
import com.challenge.itau.movies.repository.MovieRepository;
import com.challenge.itau.users.exception.UserNotFoundException;
import com.challenge.itau.users.repository.UserRepository;
import com.challenge.itau.movies.entity.Comment;
import com.challenge.itau.movies.service.CommentService;
import com.challenge.itau.users.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    @Override
    public Comment create(Comment comment) {
        comment = updatingUserAndMovie(comment);
        return commentRepository.save(comment);
    }

    @Override
    public void delete(Long id) {
        commentRepository.findById(id).orElseThrow(()->new CommentNotFoundException("You can not delete an comment with id " + id + " because this id does not exists!"));
    }

    @Override
    public Comment get(Long id) {
        return commentRepository.findById(id).orElseThrow(()->new CommentNotFoundException("Comment with id  "+  id +  " not found!"));
    }

    @Override
    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    private Comment updatingUserAndMovie(Comment comment) {
        User userToBeUpdated = userRepository.findById(comment
                .getUser()
                .getId()).orElseThrow( () -> new UserNotFoundException("User with id " + comment.getUser().getId() + " not found!"));


        Movie movieToBeUpdated = movieRepository.findById(comment
                .getMovie()
                .getId()).orElseThrow( () -> new MovieNotFoundException("Movie with id " + comment.getMovie().getId() + " not found!"));

        comment.setUser(userToBeUpdated);
        comment.setMovie(movieToBeUpdated);

        movieToBeUpdated.getComments().add(comment);
        userToBeUpdated.getComments().add(comment);
        userToBeUpdated.addingActions();
        userToBeUpdated.permissionRole();

        userRepository.saveAndFlush(userToBeUpdated);
        movieRepository.saveAndFlush(movieToBeUpdated);
        return comment;
    }
}
