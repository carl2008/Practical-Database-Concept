package com.rmit.Practical_Database_Concept.booking.controller;

import com.rmit.Practical_Database_Concept.booking.model.Booking;
import com.rmit.Practical_Database_Concept.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/booking")
public class BookingController {

    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("{movieId}/v1")
    public void save(@RequestBody Booking booking, @PathVariable int movieId) {
        bookingService.save(booking, movieId);
    }

    @PutMapping("{bookingId}/v1")
    public ResponseEntity<?> update(@RequestBody Booking booking, @PathVariable int bookingId) {
        return bookingService.update(booking, bookingId);
    }

    @DeleteMapping("{bookingId}/v1")
    public ResponseEntity<?> delete(@PathVariable int bookingId) {
        return bookingService.delete(bookingId);
    };
}
