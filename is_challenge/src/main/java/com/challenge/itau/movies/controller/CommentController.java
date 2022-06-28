package com.challenge.itau.movies.controller;

import com.challenge.itau.movies.dto.comment.CommentDTO;
import com.challenge.itau.movies.entity.Comment;
import com.challenge.itau.movies.service.CommentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("comments")
@AllArgsConstructor
public class CommentController {

    private final ModelMapper modelMapper;
    private final CommentService commentService;

    @PreAuthorize("hasAnyRole('BASIC')")
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CommentDTO dto) {
        commentService.create(modelMapper.map(dto, Comment.class));
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    @GetMapping("{id}")
    public ResponseEntity<CommentDTO> get(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(modelMapper.map(commentService.get(id), CommentDTO.class));
    }
}
