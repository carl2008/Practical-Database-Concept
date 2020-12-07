package com.rmit.Practical_Database_Concept.booking.repository;

import com.rmit.Practical_Database_Concept.booking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    Booking findOneById(int id);
}
