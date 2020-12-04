package com.luv2code.springboot.thymeleafdemo.repositories;

import com.luv2code.springboot.thymeleafdemo.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
}