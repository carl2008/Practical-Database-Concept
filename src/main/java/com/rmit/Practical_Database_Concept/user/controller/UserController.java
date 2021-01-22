package com.rmit.Practical_Database_Concept.user.controller;

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

    public UserController(UserService userService) {
        this.userService = userService;
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

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable int id) {
        userService.delete(id);
    }
}
