package com.rmit.Practical_Database_Concept.booking.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rmit.Practical_Database_Concept.movie.model.Movie;
import com.rmit.Practical_Database_Concept.timetable.entity.Timetable;
import com.rmit.Practical_Database_Concept.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "booking")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private int id;

    @ManyToOne( fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "timetable_id", nullable = false)
    private Timetable timetableId;

    @ManyToOne( fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name="user_id", nullable = false)
    private User userId;

    @Column(name = "seats", columnDefinition="integer Not NULL")
    @NotBlank
    @NotNull
    private int seats;

    @Column(name = "is_checked_in", columnDefinition = "boolean default false Not NULL")
    @NotNull
    private boolean isCheckedIn;
}
