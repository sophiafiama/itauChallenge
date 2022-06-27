package com.is_challenge.is_challenge.apiStreaming.dto.comment;

import com.is_challenge.is_challenge.apiStreaming.dto.movie.MovieResponseStreaming;
import com.is_challenge.is_challenge.apiStreaming.entity.Movie;
import com.is_challenge.is_challenge.apiUser.dto.UserResponseStreaming;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO {
    private Long id;
    private UserResponseStreaming user;
    private MovieResponseStreaming movie;
    private String title;
    private String description;
}
