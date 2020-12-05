package com.rmit.Practical_Database_Concept.booking.repository;

import com.rmit.Practical_Database_Concept.booking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking, UUID> {
    Booking findOneById(UUID id);
}
