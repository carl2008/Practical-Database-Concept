package com.rmit.Practical_Database_Concept.movie.controller;

import com.rmit.Practical_Database_Concept.movie.collection.MovieCollection;
import com.rmit.Practical_Database_Concept.movie.model.Movie;
import com.rmit.Practical_Database_Concept.movie.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/movies")
public class MovieController {

    @Autowired
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping()
    public List<Movie> list() {
        return movieService.findAll();
    }

    @GetMapping("{id}")
    public Movie findMovieById(@PathVariable int id) {
        return movieService.findById(id);
    }

    @PostMapping("/v2")
    public void save(@RequestBody MovieCollection movieCollection) {
        movieService.save(movieCollection);
    }

    @PutMapping(path = "/v2/{id}")
    public ResponseEntity<?> updateMovie(@RequestBody Movie movie, @PathVariable int id) {
        return movieService.update(movie, id);
    }

    @DeleteMapping(path = "/v2/{id}")
    public void delete(@PathVariable int id) {
        movieService.delete(id);
    }
}