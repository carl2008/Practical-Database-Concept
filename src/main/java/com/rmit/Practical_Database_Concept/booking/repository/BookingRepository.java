package com.rmit.Practical_Database_Concept.booking.repository;

import com.rmit.Practical_Database_Concept.booking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    Booking findOneById(int id);

    @Query(
        value = "SELECT * FROM booking b WHERE b.user_id = ?1",
        nativeQuery = true
    )
    public List<Booking> findBookingByUserId(Integer userId);

    @Query(
            value = "SELECT * FROM booking b WHERE b.timetable_id = ?1",
            nativeQuery = true
    )
    public List<Booking> findBookingByTimetableId(Integer timetableId);

    @Query(
        value = "SELECT * FROM booking b WHERE b.user_id = ?1 AND b.is_checked_in = ?2",
        nativeQuery = true
    )
    List<Booking> filter(Integer userId, Integer status);
}
