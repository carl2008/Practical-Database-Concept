package com.luv2code.springboot.thymeleafdemo.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "movie")
public class Movie {
    // Properties of Movie entity
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
    @Column(name = "movie_name") private String movieName;
    @Column private String directors;
    @Column private String cast;
    @Column private String category;
    @Column @Temporal(TemporalType.DATE) @DateTimeFormat(pattern = "yyyy-MM-dd") private Date premiere;
    @Column private int duration;
    @Column private String language;
    @Column private String rated;
    @Column private String description;

    // Constructor
    public Movie() {}

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

    // Getters
    public int getId() {
        return id;
    }
    public String getMovieName() {
        return movieName;
    }
    public String getDirectors() {
        return directors;
    }
    public String getCast() {
        return cast;
    }
    public String getCategory() {
        return category;
    }
    public Date getPremiere() {
        return premiere;
    }
    public int getDuration() {
        return duration;
    }
    public String getLanguage() {
        return language;
    }
    public String getRated() {
        return rated;
    }
    public String getDescription() {
        return description;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    public void setDirectors(String directors) {
        this.directors = directors;
    }
    public void setCast(String cast) {
        this.cast = cast;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setPremiere(Date premiere) {
        this.premiere = premiere;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public void setRated(String rated) {
        this.rated = rated;
    }
    public void setDescription(String description) {
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
