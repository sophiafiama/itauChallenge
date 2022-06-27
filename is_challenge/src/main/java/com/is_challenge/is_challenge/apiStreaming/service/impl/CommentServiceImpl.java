package com.is_challenge.is_challenge.apiStreaming.service.impl;

import com.is_challenge.is_challenge.apiStreaming.entity.Comment;
import com.is_challenge.is_challenge.apiStreaming.entity.Movie;
import com.is_challenge.is_challenge.apiStreaming.exception.CommentNotFoundException;
import com.is_challenge.is_challenge.apiStreaming.exception.MovieNotFoundException;
import com.is_challenge.is_challenge.apiStreaming.repository.CommentRepository;
import com.is_challenge.is_challenge.apiStreaming.repository.MovieRepository;
import com.is_challenge.is_challenge.apiStreaming.service.CommentService;
import com.is_challenge.is_challenge.apiUser.entity.User;
import com.is_challenge.is_challenge.apiUser.exception.UserNotFoundException;
import com.is_challenge.is_challenge.apiUser.repository.UserRepository;
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
