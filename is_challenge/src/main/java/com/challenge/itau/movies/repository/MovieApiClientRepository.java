package com.challenge.itau.movies.repository;

import com.challenge.itau.movies.dto.movie.MovieDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "jplaceholder", url = "http://www.omdbapi.com/")
public interface MovieApiClientRepository {

    @RequestMapping(method = RequestMethod.GET)
    MovieDTO findMovie(@RequestParam() String apikey, @RequestParam String i);

}
