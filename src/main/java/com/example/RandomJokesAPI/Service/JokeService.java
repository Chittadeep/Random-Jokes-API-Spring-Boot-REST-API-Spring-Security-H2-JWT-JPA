package com.example.RandomJokesAPI.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class JokeService {
    List<String> jokes;
    
    public JokeService()
    {
        jokes = new ArrayList<>();
        jokes.add("What falls, but never needs a bandage? The rain.");
        jokes.add("I was going to tell you a joke about boxing but I forgot the punch line.");
        jokes.add("I'm not a fan of spring cleaning. Let's be honest, I'm not into summer, fall, or winter cleaning either.");
        jokes.add("Why did the egg hide? It was a little chicken.");
        jokes.add("What did the dirt say to the rain? If you keep this up, my name will be mud!");
        jokes.add("Why couldn't the sunflower ride its bike? It lost its petals.");
        jokes.add("I ate a sock yesterday. It was very time-consuming.");
        jokes.add("What kind of candy do astronauts like? Mars bars.");
        jokes.add("I wanted to buy some camo pants but couldn't find any.");
        jokes.add("I ordered a chicken and an egg from Amazon. I'll let you know.");
        jokes.add("What month is the shortest of the year? May, it only has three letters.");
        jokes.add("What did the snail who was riding on the turtle's back say? Wheeeee!");
        jokes.add("I was going to tell a time traveling joke, but you guys didn't like it.");
        jokes.add("What do you call a lazy kangaroo? A pouch potato.");
        jokes.add("I used to run a dating service for chickens, but I was struggling to make hens meet.");
        jokes.add("Why do we tell actors to break a leg? Because every play has a cast.");
    }

    public String generateRandomJoke()
    {
        Random rand = new Random();
        return jokes.get(rand.nextInt(jokes.size()));
    }
    
}
