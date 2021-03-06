package com.challenge.itau.movies.entity;

import com.challenge.itau.users.entity.User;
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
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "movie_id")
    private Movie movie;
    private String title;
    private String description;
    @OneToMany(
            mappedBy = "comment"
    )
    @JsonIgnore
    private List<Enjoy> enjoyList = new ArrayList<>();
    @OneToMany(
            mappedBy = "comment"
    )
    @JsonIgnore
    private List<Answer> answers = new ArrayList<>();
    private Boolean isRepeated = null;


}
