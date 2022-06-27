package com.is_challenge.is_challenge.apiStreaming.dto.score;

import com.is_challenge.is_challenge.apiStreaming.dto.movie.MovieResponseStreaming;
import com.is_challenge.is_challenge.apiUser.dto.UserResponseStreaming;
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
