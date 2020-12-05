package com.rmit.Practical_Database_Concept.movie.repositories;

import com.rmit.Practical_Database_Concept.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
}