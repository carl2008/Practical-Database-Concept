package com.rmit.Practical_Database_Concept.movie.repositories;

import com.rmit.Practical_Database_Concept.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
    @Query(value = "SELECT * FROM movie mv WHERE mv.movie_name LIKE %:movieNameKeyword%", nativeQuery = true)
    List<Movie> findByMovieName(@Param("movieNameKeyword") String movieNameKeyword);

    @Query(value = "SELECT * FROM movie mv WHERE mv.category LIKE %:categoryKeyword%", nativeQuery = true)
    List<Movie> findByCategory(@Param("categoryKeyword") String categoryKeyword);

    @Query(value = "SELECT * FROM movie mv WHERE mv.rated <= :ratedKeyword", nativeQuery = true)
    List<Movie> findByRated(@Param("ratedKeyword") Integer ratedKeyword);

    @Query(value = "SELECT * FROM movie mv WHERE mv.movie_name LIKE %:movieNameKeyword% AND mv.category LIKE %:categoryKeyword%", nativeQuery = true)
    List<Movie> findByMovieNameCategory(@Param("movieNameKeyword") String movieNameKeyword, @Param("categoryKeyword") String categoryKeyword);

    @Query(value = "SELECT * FROM movie mv WHERE mv.movie_name LIKE %:movieNameKeyword% AND mv.rated <= :ratedKeyword", nativeQuery = true)
    List<Movie> findByMovieNameRated(@Param("movieNameKeyword") String movieNameKeyword, @Param("ratedKeyword") Integer ratedKeyword);

    @Query(value = "SELECT * FROM movie mv WHERE mv.category LIKE %:categoryKeyword% AND mv.rated <= :ratedKeyword", nativeQuery = true)
    List<Movie> findByCategoryRated(@Param("categoryKeyword") String categoryKeyword, @Param("ratedKeyword") Integer ratedKeyword);

    @Query(value = "SELECT * FROM movie mv WHERE mv.movie_name LIKE %:movieNameKeyword% AND mv.category LIKE %:categoryKeyword% AND mv.rated <= :ratedKeyword", nativeQuery = true)
    List<Movie> findByMovieNameCategoryRated(@Param("movieNameKeyword") String movieNameKeyword, @Param("categoryKeyword") String categoryKeyword, @Param("ratedKeyword") Integer ratedKeyword);
}