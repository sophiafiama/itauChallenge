package com.challenge.itau.movies.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @OneToMany(
            mappedBy = "movie"
    )
    @JsonIgnore
    private List<Score> scores = new ArrayList<>();

    @OneToMany(
            mappedBy = "movie"
    )
    @JsonIgnore
    private List<Comment> comments = new ArrayList<>();
    private int scoreTotal;
    private int count;
    private double mediaScore;

    public double mediaCount(int score){
        this.scoreTotal= this.scoreTotal +score;
        ++this.count;
        return this.mediaScore = ((double) this.scoreTotal)/this.count;
    }
}


