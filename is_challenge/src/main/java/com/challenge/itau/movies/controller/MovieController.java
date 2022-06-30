package com.challenge.itau.movies.controller;

import com.challenge.itau.movies.dto.movie.MovieDTO;
import com.challenge.itau.movies.dto.movie.MovieResponseDTO;
import com.challenge.itau.movies.entity.Movie;
import com.challenge.itau.movies.service.MovieService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movies")
@AllArgsConstructor
public class MovieController {

    private final MovieService service;
    private final ModelMapper modelMapper;


    @PostMapping
    public ResponseEntity<Void> create(@RequestBody MovieDTO dto) {
        System.out.println(dto.toString());
        service.create(modelMapper.map(dto, Movie.class));
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    @PreAuthorize("hasAnyRole('READER')")
    @GetMapping("{id}")
    public ResponseEntity<MovieResponseDTO> get(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        modelMapper.map(service.getById(id), MovieResponseDTO.class)
                );
    }
}
