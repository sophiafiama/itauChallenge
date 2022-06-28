package com.challenge.itau.movies.controller;

import com.challenge.itau.movies.dto.score.ScoreDTO;
import com.challenge.itau.movies.entity.Score;
import com.challenge.itau.movies.service.ScoreService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("scores")
@AllArgsConstructor
public class ScoreController {
    private final ScoreService scoreService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody ScoreDTO dto) {
        scoreService.create(modelMapper.map(dto, Score.class));
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    @GetMapping("{id}")
    public ResponseEntity<ScoreDTO> get(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(modelMapper.map(scoreService.get(id), ScoreDTO.class));
    }
}
