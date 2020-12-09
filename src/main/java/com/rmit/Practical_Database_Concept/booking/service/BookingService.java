package com.rmit.Practical_Database_Concept.booking.service;

import com.rmit.Practical_Database_Concept.booking.model.Booking;
import com.rmit.Practical_Database_Concept.booking.repository.BookingRepository;
import com.rmit.Practical_Database_Concept.categories.model.Categories;
import com.rmit.Practical_Database_Concept.movie.entity.Movie;
import com.rmit.Practical_Database_Concept.movie.service.MovieService;
import com.rmit.Practical_Database_Concept.user.model.User;
import com.rmit.Practical_Database_Concept.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.ServletRequest;
import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class BookingService {
    private static final String REQUEST_USERNAME = "request_username";

    private ServletRequest servletRequest;

    private MovieService movieService;

    private final UserService userService;

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(UserService userService, MovieService movieService, BookingRepository bookingRepository, ServletRequest servletRequest) {
        this.userService = userService;
        this.movieService = movieService;
        this.bookingRepository = bookingRepository;
        this.servletRequest = servletRequest;
    }

    public List<Booking> listAll() {
        return bookingRepository.findAll();
    }

    public Booking findById(int id) {
        return bookingRepository.findOneById(id);
    }

    public void save(Booking booking, int movieId) {
        Object objectId = servletRequest.getAttribute(REQUEST_USERNAME);

        /**
         * Refactor from User to ResponseEntity<User>
         */
        ResponseEntity<User> user = userService.findByUsername(objectId.toString());

        Movie movie = movieService.findById(movieId);

        booking.setMovieId(movie);

        /**
         * Refactor from User to ResponseEntity<User>
         */
        booking.setUserId(user.getBody());

        bookingRepository.save(booking);
    }

    public ResponseEntity<?> update(Booking booking, int bookingId) {
        try {
            Booking existBooking = bookingRepository.findOneById(bookingId);

            booking.setId(bookingId);

            bookingRepository.save(booking);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> delete(int bookingId) {
        try {
            Booking existBooking = bookingRepository.findOneById(bookingId);

            bookingRepository.deleteById(bookingId);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
