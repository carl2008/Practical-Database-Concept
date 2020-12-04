package com.luv2code.springboot.thymeleafdemo.service;

import com.luv2code.springboot.thymeleafdemo.entity.Movie;
import com.luv2code.springboot.thymeleafdemo.repositories.MovieRepository;
import com.luv2code.springboot.thymeleafdemo.serviceInterface.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService implements MovieServiceInterface {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository theMovieRepository) {
        movieRepository = theMovieRepository;
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
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

    @Override
    public void create(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public void deleteById(int id) {
        movieRepository.deleteById(id);
    }
}
