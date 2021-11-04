package com.notes.demo.services;

import com.notes.demo.User;
import com.notes.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
@Autowired
UserRepository userRepository;

public Optional<User> getUserByUsername(String username)
{
    return userRepository.findUserByNickname(username);
}
public User saveUser(User user) {
    return userRepository.save(user);
}
public void update(User user)
{
       userRepository.saveAndFlush(user);
}
}
