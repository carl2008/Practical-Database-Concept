package com.rmit.Practical_Database_Concept.booking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rmit.Practical_Database_Concept.movie.entity.Movie;
import com.rmit.Practical_Database_Concept.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

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

    @ManyToOne
    @JoinColumn(name="movie_id", nullable = false)
    @NotBlank
    @NotNull
    private Movie movieId;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    @NotBlank
    @NotNull
    private User userId;

    @Column(name = "seats", columnDefinition="integer Not NULL")
    @NotBlank
    @NotNull
    private int seats;

    @Column(name = "is_checked_in", columnDefinition = "boolean default false Not NULL")
    @NotNull
    private boolean isCheckedIn;
}
