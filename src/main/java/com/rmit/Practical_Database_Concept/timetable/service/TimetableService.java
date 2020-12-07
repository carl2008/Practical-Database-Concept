package com.rmit.Practical_Database_Concept.timetable.service;

import com.rmit.Practical_Database_Concept.timetable.entity.Timetable;
import com.rmit.Practical_Database_Concept.timetable.repositories.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimetableService {

    private final TimetableRepository timetableRepository;

    @Autowired
    public TimetableService(TimetableRepository timetableRepository) {
        this.timetableRepository = timetableRepository;
    }

    public List<Timetable> findAll() {
        return timetableRepository.findAll();
    }

    public Timetable findById(int id) {
        Optional<Timetable> result = timetableRepository.findById(id);

        Timetable movie = null;

        if (result.isPresent()) {
            movie = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find timetable id - " + id);
        }

        return movie;
    }

    public void save(Timetable timetable) {
        timetableRepository.save(timetable);
    }

    public void delete(int id) {
        timetableRepository.deleteById(id);
    }
}
