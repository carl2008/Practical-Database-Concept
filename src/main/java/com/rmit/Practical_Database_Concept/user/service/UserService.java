package com.rmit.Practical_Database_Concept.user.service;

import com.rmit.Practical_Database_Concept.booking.model.Booking;
import com.rmit.Practical_Database_Concept.user.model.User;
import com.rmit.Practical_Database_Concept.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.ServletRequest;
import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@Transactional
public class UserService {
    private static final String REQUEST_USERNAME = "request_username";

    @Autowired
    private ServletRequest servletRequest;

    @Autowired
    private UserRepository userRepository;

    public UserService(ServletRequest servletRequest, UserRepository userRepository) {
        this.servletRequest = servletRequest;
        this.userRepository = userRepository;
    }

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public User findLoggedInUser() {
        Object objectId = servletRequest.getAttribute(REQUEST_USERNAME);

        ResponseEntity<User> userResponseEntity = this.findByUsername(objectId.toString());

        return userResponseEntity.getBody();
    }

    public ResponseEntity<User> findByUsername(String username) {
        try {
            User user = userRepository.findUserByUsername(username);

            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    public void save(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        userRepository.save(user);
    }

    public ResponseEntity<?> update(User user, int userId) {
        try {
            userRepository.findById(userId).map(existUser -> {
                user.setId(existUser.getId());

                userRepository.save(user);

                return new ResponseEntity<>(HttpStatus.OK);
            });

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
