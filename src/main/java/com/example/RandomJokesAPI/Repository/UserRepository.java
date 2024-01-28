package com.example.RandomJokesAPI.Repository;

import org.springframework.data.repository.CrudRepository;
import com.example.RandomJokesAPI.Entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    public User getUserByMail(String mail);
}
