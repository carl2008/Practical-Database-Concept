package com.rmit.Practical_Database_Concept.movie.controller;

import com.rmit.Practical_Database_Concept.movie.collection.MovieCollection;
import com.rmit.Practical_Database_Concept.movie.model.Movie;
import com.rmit.Practical_Database_Concept.movie.service.MovieService;
import com.rmit.Practical_Database_Concept.user.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/home")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/list")
    public String listMovies(Model theModel, String keyword) {

        List<Movie> movies = movieService.findAll();

        theModel.addAttribute("movies", movies);

        return "index";
    }

//    @PostMapping("/save")
//    public void save(@RequestBody MovieCollection movieCollection) {
//        movieService.save(movieCollection);
//    }
//
//    @PutMapping(path = "/update/{id}")
//    public ResponseEntity<?> updateMovie(@RequestBody Movie movie, @PathVariable int id) {
//        return movieService.update(movie, id);
//    }

//    @DeleteMapping(path = "/delete/{id}")
//    public void delete(@PathVariable int id) {
//        movieService.delete(id);
//    }

    @GetMapping("/detail")
    public String movieDetail(@RequestParam("movieId")int theId, Model theModel){
        //get the employee from service
        Movie movie = movieService.findById(theId);
        //set the employee as a model attribute to pre-populate the form
        theModel.addAttribute("movie", movie);
        // send over to our form
        return "movie-detail";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("movieId")int theId, Model theModel){
        //get the employee from service
        Movie movie = movieService.findById(theId);
        //set the employee as a model attribute to pre-populate the form
        theModel.addAttribute("movie", movie);
        // send over to our form
        return "addUpdate/movie";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("movieId")int theId){
        //get the employee
        movieService.delete(theId);
        //redirect to list
        return "redirect:/home/list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Movie movie = new Movie();

        theModel.addAttribute("movie", movie);

        return "addUpdate/movie";
    }

    @PostMapping("/save")
    public String saveMovie(@ModelAttribute("movie") Movie movie) {

        // save the employee
        movieService.save(movie);

        // use a redirect to prevent duplicate submissions
        return "redirect:/home/list";
    }
}
