package com.challenge.itau.users.entity;

import com.challenge.itau.movies.entity.Comment;
import com.challenge.itau.movies.entity.Score;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "roles")
    private Set<Integer> roles = new HashSet<>();
    private Integer actions = 0;
    @OneToMany(
            mappedBy = "user"
    )
    @JsonIgnore
    private List<Score> scores = new ArrayList<>();
    @OneToMany(
            mappedBy = "user"
    )
    @JsonIgnore
    private List<Comment> comments = new ArrayList<>();

    public Set<Role> getRoles() {
        return roles.stream().map(Role::toEnum).collect(Collectors.toSet());
    }

    public void addRole(Role role) {
        roles.add(role.getCod());
    }

    public void addingActions() {
        ++actions;
    }

    public void permissionRole() {
        if (this.actions > 0 && this.actions < 20) {
            addRole(Role.READER);

        } else if (this.actions >= 20 && this.actions < 100) {
            addRole(Role.BASIC);
        } else if (this.actions >= 100 && this.actions < 1000) {
            addRole(Role.ADVANCED);
        } else {
            addRole(Role.ADMIN);
        }
    } ;


}

