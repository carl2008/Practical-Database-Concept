package com.rmit.Practical_Database_Concept.movie.controller;

import com.rmit.Practical_Database_Concept.movie.entity.Movie;
import com.rmit.Practical_Database_Concept.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/v1/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping()
    public List<Movie> list() {
        return movieService.findAll();
    }

    @PostMapping()
    public void createNewMovie(@RequestBody Movie movie) {
        movieService.save(movie);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<?> updateMovie(@RequestBody Movie movie, @PathVariable int id) {
        try {
            Movie existingMovie = movieService.findById(id);

            movie.setId(id);

            movieService.save(movie);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable int id) {
        movieService.delete(id);
    }
}