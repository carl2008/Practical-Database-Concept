package com.rmit.Practical_Database_Concept.booking.repository;

import com.rmit.Practical_Database_Concept.booking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    Booking findOneById(int id);

    @Query(
        value = "SELECT * FROM booking b WHERE b.user_id = ?1",
        nativeQuery = true
    )
    public List<Booking> findBookingByUserId(Integer userId);
}
