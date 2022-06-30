package com.challenge.itau.movies.service.impl;

import com.challenge.itau.movies.entity.Answer;
import com.challenge.itau.movies.entity.Comment;
import com.challenge.itau.movies.exception.CommentNotFoundException;
import com.challenge.itau.movies.repository.AnswerRepository;
import com.challenge.itau.movies.repository.CommentRepository;
import com.challenge.itau.movies.service.AnswerService;
import com.challenge.itau.users.entity.User;
import com.challenge.itau.users.exception.UserNotFoundException;
import com.challenge.itau.users.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;


    @Override
    public Answer create(Answer answer) {
        answer = updatingUserAndComment(answer);
        return answerRepository.save(answer);
    }

    @Override
    public void delete(Long id) {
        answerRepository.deleteById(id);
    }

    private Answer updatingUserAndComment(Answer answer) {

        User userToBeUpdated = userRepository.findById(answer.getUser().getId()).orElseThrow(() -> new UserNotFoundException("User with id " + answer.getUser().getId() + " not found!"));

        Comment commentToBeUpdated = commentRepository.findById(answer
                .getComment()
                .getId()).orElseThrow( () -> new CommentNotFoundException("Comment with id " + answer.getComment().getId() + " not found!"));

        answer.setUser(userToBeUpdated);
        answer.setComment(commentToBeUpdated);

        commentToBeUpdated.getAnswers().add(answer);
        userToBeUpdated.getAnswers().add(answer);
        userToBeUpdated.addingActions();
        userToBeUpdated.permissionRole();

        userRepository.save(userToBeUpdated);
        commentRepository.save(commentToBeUpdated);
        return answer;
    }
}
