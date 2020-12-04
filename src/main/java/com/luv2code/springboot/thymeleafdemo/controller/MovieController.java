package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Movie;
import com.luv2code.springboot.thymeleafdemo.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/list")
    public String listMovies(Model theModel, String keyword) {

        // get employees from db
        List<Movie> theMovies = movieService.findAll();

        theModel.addAttribute("movies", theMovies);

        return "movie";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("movieId")int theId){
        //get the employee
        movieService.deleteById(theId);
        //redirect to list
        return "redirect:/movies/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("movieId")int theId, Model theModel){
        //get the employee from service
        Movie movie = movieService.findById(theId);
        //set the employee as a model attribute to pre-populate the form
        theModel.addAttribute("movie", movie);
        // send over to our form
        return "add-update-form";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Movie movie = new Movie();

        theModel.addAttribute("movie", movie);

        return "add-update-form";
    }

    @PostMapping("/save")
    public String saveMovie(@ModelAttribute("movie") Movie movie) {

        // save the employee
        movieService.create(movie);

        // use a redirect to prevent duplicate submissions
        return "redirect:/movies/list";
    }
}