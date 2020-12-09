package com.rmit.Practical_Database_Concept.user.controller;

import com.rmit.Practical_Database_Concept.user.model.User;
import com.rmit.Practical_Database_Concept.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> list() {
        return userService.listAll();
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
