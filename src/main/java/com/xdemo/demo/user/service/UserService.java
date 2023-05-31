package com.xdemo.demo.user.service;


import com.xdemo.demo.exc.NotFound;
import com.xdemo.demo.user.entity.User;
import com.xdemo.demo.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getById(Integer id) {
        return userRepository.findById(id).orElseThrow(NotFound::new);
    }

    public User save(User reservation) {
        return userRepository.save(reservation);
    }
}

