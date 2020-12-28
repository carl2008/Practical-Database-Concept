package com.rmit.Practical_Database_Concept.movie.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rmit.Practical_Database_Concept.timetable.entity.Timetable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import org.hibernate.mapping.Set;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "movie")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movie implements Serializable {
    // Properties of Movie model
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

    @Column(columnDefinition = "text")
    private String description;

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnoreProperties({ "movie" })
    private Set<Timetable> timetables;

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
