package com.example.RandomJokesAPI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.RandomJokesAPI.Service.JokeService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class JokeController {
    @Autowired
    private JokeService jokeService;

    @GetMapping("/")
    public ResponseEntity<String> getJoke() {
        return new ResponseEntity<String>(jokeService.generateRandomJoke(), HttpStatus.OK);
    }
    
}
