package com.xdemo.demo.user.service;


import com.xdemo.demo.exc.NotFound;
import com.xdemo.demo.user.entity.User;
import com.xdemo.demo.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getDtoById(Integer id) {
        return getById(id);
    }

    public User saveDto(User user) {
        return save(user);
    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User getById(Integer id) {
        return userRepository.findById(id).orElseThrow(NotFound::new);
    }
}

