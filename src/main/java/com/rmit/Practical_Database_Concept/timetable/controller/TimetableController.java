package com.rmit.Practical_Database_Concept.timetable.controller;

import com.rmit.Practical_Database_Concept.timetable.entity.Timetable;
import com.rmit.Practical_Database_Concept.timetable.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/v1/timetables")
public class TimetableController {

    private final TimetableService timetableService;

    @Autowired
    public TimetableController(TimetableService timetableService) {
        this.timetableService = timetableService;
    }

    @GetMapping()
    public List<Timetable> list() {
        return timetableService.findAll();
    }

    @PostMapping()
    public void createNewTimetable(@RequestBody Timetable timetable) {
        timetableService.save(timetable);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<?> updateTimetable(@RequestBody Timetable timetable, @PathVariable int id) {
        try {
            Timetable existingTimetable = timetableService.findById(id);

            timetable.setId(id);

            timetableService.save(timetable);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable int id) {
        timetableService.delete(id);
    }
}