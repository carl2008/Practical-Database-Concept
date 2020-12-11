package com.rmit.Practical_Database_Concept.timetable.entity;

import com.rmit.Practical_Database_Concept.movie.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "timetable")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Timetable {
    // Properties of Timetable entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "time_slot")
    @NotBlank
    @NotNull
    private int timeslot;

    @Column
    @NotBlank
    @NotNull
    private int seat_available;

    @ManyToOne
    @JoinColumn(name="movie_id", nullable = false)
    @NotBlank
    @NotNull
    private Movie movie;

    @Override
    public String toString() {
        return "Timetable{" +
                "id=" + id +
                ", timeslot=" + timeslot +
                ", seat_available=" + seat_available +
                '}';
    }
}
