package com.rmit.Practical_Database_Concept.timetable.repositories;

import com.rmit.Practical_Database_Concept.timetable.entity.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimetableRepository extends JpaRepository<Timetable,Integer> {
}