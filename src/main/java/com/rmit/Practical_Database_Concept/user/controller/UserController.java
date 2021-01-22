package com.rmit.Practical_Database_Concept.user.controller;

import com.rmit.Practical_Database_Concept.booking.service.BookingService;
import com.rmit.Practical_Database_Concept.user.model.User;
import com.rmit.Practical_Database_Concept.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final BookingService bookingService;

    public UserController(UserService userService, BookingService bookingService) {
        this.userService = userService;
        this.bookingService = bookingService;
    }

    @GetMapping("/list")
    public String list(Model theModel) {
//        return userService.listAll();
        List<User> users = userService.listAll();
        theModel.addAttribute("users", users);

        return "user";
    }

    @GetMapping(path = "{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @PostMapping("/v1")
    public void save(@RequestBody User user) {
        userService.save(user);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<?> update(@RequestBody User user, @PathVariable int id) {
        return userService.update(user, id);
    }

//    @DeleteMapping(path = "{id}")
//    public void delete(@PathVariable int id) {
//        userService.delete(id);
//    }

    @GetMapping("/delete")
    public String delete(@RequestParam("userId")int theId){

        bookingService.deleteByUserId(theId);
        userService.deleteById(theId);

        return "redirect:/api/users/list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        User user = new User();

        theModel.addAttribute("user", user);

        return "addUpdate/user";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("userId")int theId, Model theModel){
        //get the user from service
        User user = userService.findById(theId);
        //set the user as a model attribute to pre-populate the form
        theModel.addAttribute("user", user);
        // send over to our form
        return "addUpdate/user";
    }
    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {

        // save the user
        userService.create(user);

        // use a redirect to prevent duplicate submissions
        return "redirect:/api/users/list";
    }
}

