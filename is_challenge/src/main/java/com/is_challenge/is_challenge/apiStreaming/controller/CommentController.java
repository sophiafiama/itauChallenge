package com.is_challenge.is_challenge.apiStreaming.controller;

import com.is_challenge.is_challenge.apiStreaming.dto.comment.CommentDTO;
import com.is_challenge.is_challenge.apiStreaming.entity.Comment;
import com.is_challenge.is_challenge.apiStreaming.service.CommentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("comments")
@AllArgsConstructor
public class CommentController {

    private final ModelMapper modelMapper;
    private final CommentService commentService;

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
