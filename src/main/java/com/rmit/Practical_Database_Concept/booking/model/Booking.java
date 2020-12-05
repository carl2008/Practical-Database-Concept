package com.rmit.Practical_Database_Concept.booking.model;

import com.rmit.Practical_Database_Concept.movie.entity.Movie;
import com.rmit.Practical_Database_Concept.user.model.User;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "booking")
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false, unique=true, columnDefinition = "BINARY(16)")
    private UUID id;

    @ManyToOne
    @JoinColumn(name="movie_id")
    @NotBlank
    @NotNull
    private Movie movieId;

    @ManyToOne
    @JoinColumn(name="user_id")
    @NotBlank
    @NotNull
    private User userId;

    @Column(name = "seats", columnDefinition="integer Not NULL")
    @NotBlank
    @NotNull
    private int seats;

    @Column(name = "isCheckedIn", columnDefinition = "boolean default false Not NULL")
    @NotNull
    private boolean isCheckedIn;

    public Booking(UUID id, @NotBlank @NotNull Movie movieId, @NotBlank @NotNull User userId, @NotBlank @NotNull int seats, boolean isCheckedIn) {
        this.id = id;
        this.movieId = movieId;
        this.userId = userId;
        this.seats = seats;
        this.isCheckedIn = isCheckedIn;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Movie getMovieId() {
        return movieId;
    }

    public void setMovieId(Movie movieId) {
        this.movieId = movieId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public boolean isCheckedIn() {
        return isCheckedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        isCheckedIn = checkedIn;
    }
}
