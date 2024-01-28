package com.example.RandomJokesAPI.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.RandomJokesAPI.Entity.User;
import com.example.RandomJokesAPI.Repository.UserRepository;

@Component
public class UserLoginService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByMail(username);
        return org.springframework.security.core.userdetails.User.builder().username(user.getMail())
        .password(passwordEncoder.encode(user.getPassword())).authorities("USER").build();
    }    
}
