package com.challenge.itau.movies.dto.comment;

import com.challenge.itau.movies.dto.movie.MovieResponseDTO;
import com.challenge.itau.users.dto.UserResponseStreaming;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO {

    private Long id;
    private UserResponseStreaming user;
    private MovieResponseDTO movie;
    private String title;
    private String description;
}
