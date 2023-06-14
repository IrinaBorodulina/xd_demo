package com.xdemo.demo.user.service;


import com.xdemo.demo.exc.NotFound;
import com.xdemo.demo.user.dto.UserDto;
import com.xdemo.demo.user.entity.User;
import com.xdemo.demo.user.mapper.UserMapper;
import com.xdemo.demo.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository,
                       UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto getDtoById(Integer id) {
        return userMapper.toDto(getById(id));
    }

    public UserDto saveDto(UserDto userDto) {
        return userMapper.toDto(save(userMapper.toEntity(userDto)));
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

