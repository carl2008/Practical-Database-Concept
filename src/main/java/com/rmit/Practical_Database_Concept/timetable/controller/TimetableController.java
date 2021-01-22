package com.rmit.Practical_Database_Concept.timetable.controller;

import com.rmit.Practical_Database_Concept.booking.service.BookingService;
import com.rmit.Practical_Database_Concept.movie.model.Movie;
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
    private final BookingService bookingService;

    public TimetableController(TimetableService timetableService, BookingService bookingService) {
        this.timetableService = timetableService;
        this.bookingService = bookingService;

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

//    @DeleteMapping(path = "/delete/{id}")
//    public String delete(@PathVariable int id) {
//        timetableService.delete(id);
//        return "redirect:/api/timetables/list";
//    }
    @GetMapping("/delete")
    public String delete(@RequestParam("timetableId")int theId){
    //get the employee
        bookingService.deleteByTimetableId(theId);
        timetableService.delete(theId);

        //redirect to list
        return "redirect:/api/timetables/list";
}

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Timetable timetable = new Timetable();

        theModel.addAttribute("timetable", timetable);

        return "addUpdate/timetable";
    }
    @PostMapping("/save")
    public String saveTimetable(@ModelAttribute("timetable") Timetable timetable) {

        // save the timetable
        timetableService.create(timetable);

        // use a redirect to prevent duplicate submissions
        return "redirect:/api/timetables/list";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("timetableId")int theId, Model theModel){
        //get the user from service
        Timetable timetable = timetableService.findById(theId);
        //set the user as a model attribute to pre-populate the form
        theModel.addAttribute("timetable", timetable);
        // send over to our form
        return "addUpdate/timetable";
    }
}
