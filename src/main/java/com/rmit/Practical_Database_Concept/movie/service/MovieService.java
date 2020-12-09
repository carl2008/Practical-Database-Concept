package com.rmit.Practical_Database_Concept.movie.service;

import com.rmit.Practical_Database_Concept.movie.model.Movie;
import com.rmit.Practical_Database_Concept.movie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
            throw new RuntimeException("Did not find movie id - " + id);
        }

        return movie;
    }

    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    public void delete(int id) {
        movieRepository.deleteById(id);
    }
}
