package com.challenge.itau.movies.dto.answer;

import com.challenge.itau.movies.dto.comment.CommentResponseDTO;
import com.challenge.itau.users.dto.UserResponseStreaming;

public class AnswerDTO {

    private Long id;
    private UserResponseStreaming user;
    private CommentResponseDTO comment;
    private String answers;

}
