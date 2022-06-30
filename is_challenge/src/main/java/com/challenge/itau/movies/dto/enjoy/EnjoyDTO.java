package com.challenge.itau.movies.dto.enjoy;

import com.challenge.itau.movies.dto.comment.CommentResponseDTO;
import com.challenge.itau.users.dto.UserResponseStreaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnjoyDTO {
    private Long id;
    private UserResponseStreaming user;
    private CommentResponseDTO comment;
    private Boolean enjoy;
}
