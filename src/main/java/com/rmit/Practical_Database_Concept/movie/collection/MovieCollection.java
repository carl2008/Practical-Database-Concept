package com.rmit.Practical_Database_Concept.movie.collection;

import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Getter
public class MovieCollection {
    private String movieName;

    private String directors;

    private String cast;

    private String category;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date premiere;

    private int duration;

    private String language;

    private int rated;

    private String description;

    private List<Object> timetable;
}
