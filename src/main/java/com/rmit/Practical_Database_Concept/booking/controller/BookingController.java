package com.rmit.Practical_Database_Concept.booking.controller;

import com.rmit.Practical_Database_Concept.booking.model.Booking;
import com.rmit.Practical_Database_Concept.booking.service.BookingService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/booking")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/find/{userId}")
    public List<Booking> findBookingByUserId(@PathVariable int userId) {
        return bookingService.findBookingByUserId(userId);
    }

    @GetMapping("/list")
    public String findAllBooking(Model theModel) {
        List<Booking> bookings = bookingService.findAll();
        theModel.addAttribute("bookings", bookings);

        return "booking";
    }

    @GetMapping("/v1/filter")
    public List<Booking> filterBookingByCheckedIn(@Param("status") int status) {
        return bookingService.filterBookingByCheckedIn(status);
    }
    /**
     * booking
     * timetableId
     * @param userId -- dirty plan
     */
//    @PostMapping("{movieId}/v1")
//    public void save(@RequestBody Booking booking, @PathVariable int movieId) {
//        bookingService.save(booking, movieId);
//    }

    @PostMapping("/save/{timetableId}/{userId}")
    public void save(@RequestBody Booking booking, @PathVariable int timetableId, @PathVariable int userId) {
        bookingService.save(booking, timetableId, userId);
    }

//    @PutMapping("{bookingId}/v1")
//    public ResponseEntity<?> update(@RequestBody Booking booking, @PathVariable int bookingId) {
//        return bookingService.update(booking, bookingId);
//    }

    @PutMapping("/update/{bookingId}")
    public ResponseEntity<?> update(@RequestBody Booking booking, @PathVariable int bookingId) {
        return bookingService.update(booking, bookingId);
    }

//    @DeleteMapping("{bookingId}/v1")
//    public ResponseEntity<?> delete(@PathVariable int bookingId) {
//        return bookingService.delete(bookingId);
//    };

    @DeleteMapping("/delete/{bookingId}")
    public ResponseEntity<?> delete(@PathVariable int bookingId) {
        return bookingService.delete(bookingId);
    }
}
