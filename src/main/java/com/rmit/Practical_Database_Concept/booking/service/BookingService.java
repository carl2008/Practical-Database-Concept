package com.rmit.Practical_Database_Concept.booking.service;

import com.rmit.Practical_Database_Concept.booking.model.Booking;
import com.rmit.Practical_Database_Concept.booking.repository.BookingRepository;
import com.rmit.Practical_Database_Concept.movie.model.Movie;
import com.rmit.Practical_Database_Concept.movie.service.MovieService;
import com.rmit.Practical_Database_Concept.timetable.entity.Timetable;
import com.rmit.Practical_Database_Concept.timetable.service.TimetableService;
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

@Service
@Transactional
public class BookingService {
    private static final String REQUEST_USERNAME = "request_username";

    @Autowired
    private ServletRequest servletRequest;

    @Autowired
    private MovieService movieService;

    @Autowired
    private final UserService userService;

    @Autowired
    private final BookingRepository bookingRepository;

    @Autowired
    private final TimetableService timetableService;

    public BookingService(UserService userService, MovieService movieService, TimetableService timetableService, BookingRepository bookingRepository, ServletRequest servletRequest) {
        this.userService = userService;
        this.movieService = movieService;
        this.timetableService = timetableService;
        this.bookingRepository = bookingRepository;
        this.servletRequest = servletRequest;
    }

    public List<Booking> findBookingByUserId(int userId) {
//        User user = userService.findLoggedInUser();

        User user = userService.findUserById(userId).getBody();

        return bookingRepository.findBookingByUserId(user.getId());
    }

    public List<Booking> filterBookingByCheckedIn(int checkedInStatus) {
        User user = userService.findLoggedInUser();

        return bookingRepository.filter(user.getId(), checkedInStatus);
    }

    public Booking findById(int id) {
        return bookingRepository.findOneById(id);
    }

    public void save(Booking booking, int timetableId, int userId) {
        Timetable timetable = timetableService.findById(timetableId);

        booking.setTimetableId(timetable);

        User user = userService.findUserById(userId).getBody();

        booking.setUserId(user);

//        booking.setUserId(userService.findLoggedInUser());

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
