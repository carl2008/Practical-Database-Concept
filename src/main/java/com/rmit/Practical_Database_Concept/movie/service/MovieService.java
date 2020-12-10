package com.rmit.Practical_Database_Concept.movie.service;

import com.rmit.Practical_Database_Concept.movie.model.Movie;
import com.rmit.Practical_Database_Concept.movie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Movie findById(int id) {
        Optional<Movie> result = movieRepository.findById(id);

        Movie movie = null;

        if (result.isPresent()) {
            movie = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find movie with id - " + id);
        }

        return movie;
    }

    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    public ResponseEntity<?> update(Movie movie, int id) {
        try {
            Optional<Movie> result = movieRepository.findById(id);

            movie.setId(id);

            movieRepository.save(movie);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public void delete(int id) {
        movieRepository.deleteById(id);
    }
}
