package com.rmit.Practical_Database_Concept.movie.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "movie")
@Getter
@Setter
@NoArgsConstructor
public class Movie {
    // Properties of Movie entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "movie_name")
    private String movieName;

    @Column
    private String directors;

    @Column
    private String cast;

    @Column
    private String category;

    @Column
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date premiere;

    @Column
    private int duration;

    @Column
    private String language;

    @Column
    private String rated;

    @Column
    private String description;

    // Constructor
    public Movie(String movieName, String directors, String cast, String category, Date premiere, int duration, String language, String rated, String description) {
        this.movieName = movieName;
        this.directors = directors;
        this.cast = cast;
        this.category = category;
        this.premiere = premiere;
        this.duration = duration;
        this.language = language;
        this.rated = rated;
        this.description = description;
    }

    // toString
    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", movieName='" + movieName + '\'' +
                ", directors='" + directors + '\'' +
                ", cast='" + cast + '\'' +
                ", category='" + category + '\'' +
                ", premiere=" + premiere +
                ", duration=" + duration +
                ", language='" + language + '\'' +
                ", rated='" + rated + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
