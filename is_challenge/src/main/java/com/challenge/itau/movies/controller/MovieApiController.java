//package com.challenge.itau.movies.controller;
//
//import com.challenge.itau.movies.dto.movie.MovieDTO;
//import com.challenge.itau.movies.repository.MovieApiClientRepository;
//import lombok.AllArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@AllArgsConstructor
//@RequestMapping("api")
//public class MovieApiController {
//
//    private final MovieApiClientRepository repository;
//
//    @GetMapping({})
//    public MovieDTO findMovie(@PathVariable String apikey, @PathVariable String i){
//        return repository.findMovie(apikey, i);
//    }
//}
