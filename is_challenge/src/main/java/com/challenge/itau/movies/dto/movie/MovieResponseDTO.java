package com.challenge.itau.movies.dto.movie;

import com.challenge.itau.movies.dto.comment.CommentDTO;
import com.challenge.itau.movies.dto.comment.CommentResponseDTO;
import com.challenge.itau.movies.dto.score.ScoreDTO;
import com.challenge.itau.movies.dto.score.ScoreResponseDTO;
import com.challenge.itau.movies.entity.Comment;
import com.challenge.itau.movies.entity.Score;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MovieResponseDTO {
    private Long id;
    private String title;
    private List<ScoreResponseDTO> scores;
    private String imdbID;
    private List<CommentResponseDTO> comments;
    private double mediaScore;
}
