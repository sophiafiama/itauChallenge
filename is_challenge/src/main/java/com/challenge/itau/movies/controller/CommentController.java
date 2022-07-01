package com.challenge.itau.movies.controller;

import com.challenge.itau.movies.dto.answer.AnswerDTO;
import com.challenge.itau.movies.dto.comment.CommentDTO;
import com.challenge.itau.movies.dto.enjoy.EnjoyDTO;
import com.challenge.itau.movies.entity.Answer;
import com.challenge.itau.movies.entity.Comment;
import com.challenge.itau.movies.entity.Enjoy;
import com.challenge.itau.movies.service.AnswerService;
import com.challenge.itau.movies.service.CommentService;
import com.challenge.itau.movies.service.EnjoyService;
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
    private final EnjoyService enjoyService;
    private final AnswerService answerService;

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


    @PreAuthorize("hasAnyRole('ADVANCED')")
    @PostMapping("enjoy")
    public ResponseEntity<Void> create(@RequestBody EnjoyDTO dto) {
        enjoyService.create(modelMapper.map(dto, Enjoy.class));
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }


    @PreAuthorize("hasAnyRole('ADVANCED')")
    @PostMapping("answer")
    public ResponseEntity<Void> create(@RequestBody AnswerDTO dto) {
        answerService.create(modelMapper.map(dto, Answer.class));
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

}
