package com.challenge.itau.movies.dto.score;

import com.challenge.itau.movies.dto.movie.MovieResponseStreaming;
import com.challenge.itau.users.dto.UserResponseStreaming;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class ScoreDTO {
    private Long id;
    private UserResponseStreaming user;
    private MovieResponseStreaming movie;
    private Integer score;
}
