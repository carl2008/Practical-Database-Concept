package com.rmit.Practical_Database_Concept.timetable.service;

import com.rmit.Practical_Database_Concept.movie.model.Movie;
import com.rmit.Practical_Database_Concept.movie.service.MovieService;
import com.rmit.Practical_Database_Concept.timetable.entity.Timetable;
import com.rmit.Practical_Database_Concept.timetable.repositories.TimetableRepository;
import com.rmit.Practical_Database_Concept.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TimetableService {

    @Autowired
    private final TimetableRepository timetableRepository;

    @Autowired
    private final MovieService movieService;

    public TimetableService(TimetableRepository timetableRepository, MovieService movieService) {
        this.timetableRepository = timetableRepository;
        this.movieService = movieService;
    }

    public List<Timetable> findAll() {
        return timetableRepository.findAll();
    }
    public List<Timetable> listAll() {
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

    public ResponseEntity<?> save(Timetable timetable, int movieId) {
        try {
            Movie movie = movieService.findById(movieId);

            timetable.setMovie(movie);

            timetableRepository.save(timetable);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> update(Timetable timetable, int timeTableId) {
        try {
            Timetable existTimeTable = timetableRepository.findOneById(timeTableId);

            timetable.setId(timeTableId);

            timetableRepository.save(timetable);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public void delete(int id) {
        timetableRepository.deleteById(id);
    }
    public void create(Timetable timetable) {
        timetableRepository.save(timetable);
    }
}
