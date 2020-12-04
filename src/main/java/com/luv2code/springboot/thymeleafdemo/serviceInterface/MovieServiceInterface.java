package com.luv2code.springboot.thymeleafdemo.serviceInterface;

import com.luv2code.springboot.thymeleafdemo.entity.Movie;

import java.util.List;

public interface MovieServiceInterface {
    public List<Movie> findAll();
    public Movie findById(int id);
    public void create(Movie movie);
    public void deleteById(int id);
}
