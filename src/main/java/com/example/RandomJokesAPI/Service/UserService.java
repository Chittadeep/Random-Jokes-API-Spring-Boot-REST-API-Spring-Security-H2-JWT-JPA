package com.example.RandomJokesAPI.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.RandomJokesAPI.Entity.User;
import com.example.RandomJokesAPI.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User register(User user)
    {
        return userRepository.save(user);
    }

}
