package com.xdemo.demo.user.crud;

import com.xdemo.demo.exc.NotFound;
import com.xdemo.demo.user.entity.User;
import com.xdemo.demo.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserCRUD {

    private final UserRepository userRepository;

    public UserCRUD(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getById(Integer id) {
        return userRepository.findById(id).orElseThrow(NotFound::new);
    }

    public User save(User reservation) {
        return userRepository.save(reservation);
    }
}
