package com.rmit.Practical_Database_Concept.user.controller;

import com.rmit.Practical_Database_Concept.user.model.User;
import com.rmit.Practical_Database_Concept.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

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

//    @GetMapping(path = "{id}")
//    public ResponseEntity<User> getUserByUsername(@PathVariable UUID id) {
//        try {
//            User user = userService.findByUuid(id);
//
//            return new ResponseEntity<User>(user, HttpStatus.OK);
//        } catch (NoSuchElementException e) {
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
//    }

    @PostMapping("/v1")
    public void createNewUser(@RequestBody User user) {
        userService.save(user);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable int id) {
        try {
            User existUser = userService.findOneById(id);

            user.setId(id);

            userService.save(user);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable int id) {
        userService.delete(id);
    }
}
