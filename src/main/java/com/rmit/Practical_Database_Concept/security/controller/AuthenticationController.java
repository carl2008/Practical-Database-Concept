package com.rmit.Practical_Database_Concept.security.controller;

import com.rmit.Practical_Database_Concept.security.model.AuthenticationRequest;
import com.rmit.Practical_Database_Concept.security.model.AuthenticationResponse;
import com.rmit.Practical_Database_Concept.security.service.UserDetailService;
import com.rmit.Practical_Database_Concept.security.util.JwtUtil;
import com.rmit.Practical_Database_Concept.user.model.User;
import com.rmit.Practical_Database_Concept.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/authenticate")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final UserDetailService userDetailService;

    private final JwtUtil jwtUtil;

    private final UserService userService;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, UserDetailService userDetailService, JwtUtil jwtUtil, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userDetailService = userDetailService;
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailService.loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    };

    @PostMapping("/register")
    public ResponseEntity<?> signUp(@RequestBody User user) {
        ResponseEntity<User> userChecked = userService.findByUsername(user.getUsername());

        if (userChecked.hasBody()) {
            return new ResponseEntity<>("Username is existed",HttpStatus.FOUND);
        }

        userService.save(user);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
