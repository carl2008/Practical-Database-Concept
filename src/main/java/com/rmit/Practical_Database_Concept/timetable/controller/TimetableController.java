package com.rmit.Practical_Database_Concept.timetable.controller;

import com.rmit.Practical_Database_Concept.timetable.entity.Timetable;
import com.rmit.Practical_Database_Concept.timetable.service.TimetableService;
import com.rmit.Practical_Database_Concept.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("api/timetables")
public class TimetableController {


    private final TimetableService timetableService;

    public TimetableController(TimetableService timetableService) {
        this.timetableService = timetableService;
    }

    @GetMapping("/list")
    public String list(Model theModel) {
//        return userService.listAll();
        List<Timetable> timetables = timetableService.listAll();
        theModel.addAttribute("timetables", timetables);

        return "timetable";
    }
//    @GetMapping()
//    public List<Timetable> list() {
//        return timetableService.findAll();
//    }

//    @PostMapping("/v2/{movieId}")
//    public ResponseEntity<?> createNewTimetable(@RequestBody Timetable timetable, @PathVariable int movieId) {
//        return timetableService.save(timetable, movieId);
//    }

    @PostMapping("/save/{movieId}")
    public ResponseEntity<?> createNewTimetable(@RequestBody Timetable timetable, @PathVariable int movieId) {
        return timetableService.save(timetable, movieId);
    }

//    @PutMapping(path = "/v2/{id}")
//    public ResponseEntity<?> updateTimetable(@RequestBody Timetable timetable, @PathVariable int timeTableId) {
//        return timetableService.update(timetable, timeTableId);
//    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<?> updateTimetable(@RequestBody Timetable timetable, @PathVariable int timeTableId) {
        return timetableService.update(timetable, timeTableId);
    }

//    @DeleteMapping(path = "/v2/{id}")
//    public void delete(@PathVariable int id) {
//        timetableService.delete(id);
//    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable int id) {
        timetableService.delete(id);
    }
}