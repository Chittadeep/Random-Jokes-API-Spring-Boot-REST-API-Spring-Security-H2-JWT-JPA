package com.example.RandomJokesAPI.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.RandomJokesAPI.Config.JwtService;
import com.example.RandomJokesAPI.Entity.User;
import com.example.RandomJokesAPI.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return new ResponseEntity<User>(userService.register(user), HttpStatus.CREATED);
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user)
    {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getMail(), user.getPassword()));
        if(authentication.isAuthenticated())
            return ResponseEntity.ok().body(jwtService.generateToken(user.getMail()));
        else
            return ResponseEntity.status(401).body("Invalid credentials");
    }
}
