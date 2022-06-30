package com.challenge.itau.movies.service.impl;

import com.challenge.itau.movies.entity.Comment;
import com.challenge.itau.movies.entity.Enjoy;
import com.challenge.itau.movies.exception.CommentNotFoundException;
import com.challenge.itau.movies.repository.CommentRepository;
import com.challenge.itau.movies.repository.EnjoyRepository;
import com.challenge.itau.movies.service.EnjoyService;
import com.challenge.itau.users.entity.User;
import com.challenge.itau.users.exception.UserNotFoundException;
import com.challenge.itau.users.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EnjoyServiceImpl implements EnjoyService {

    private final EnjoyRepository enjoyRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    @Override
    public Enjoy create(Enjoy enjoy) {
        enjoy = updatingUserAndComment(enjoy);
        return enjoyRepository.save(enjoy);
    }

    private Enjoy updatingUserAndComment(Enjoy enjoy) {
        User userToBeUpdated = userRepository.findById(enjoy
                .getUser()
                .getId()).orElseThrow( () -> new UserNotFoundException("User with id " + enjoy.getUser().getId() + " not found!"));


        Comment commentToBeUpdated = commentRepository.findById(enjoy
                .getComment()
                .getId()).orElseThrow( () -> new CommentNotFoundException("Comment with id " + enjoy.getComment().getId() + " not found!"));

        enjoy.setUser(userToBeUpdated);
        enjoy.setComment(commentToBeUpdated);

        commentToBeUpdated.getEnjoyList().add(enjoy);
        userToBeUpdated.getEnjoyList().add(enjoy);
        userToBeUpdated.addingActions();
        userToBeUpdated.permissionRole();

        userRepository.save(userToBeUpdated);
        commentRepository.save(commentToBeUpdated);
        return enjoy;
    }


}
