package com.xdemo.demo.user.service;


import com.xdemo.demo.user.crud.UserCRUD;
import com.xdemo.demo.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserCRUD userCRUD;

    @Autowired
    public UserService(UserCRUD userCRUD) {
        this.userCRUD = userCRUD;
    }

    public User save(User reservation) {
        return userCRUD.save(reservation);
    }

    public User getById(Integer id) {
        return userCRUD.getById(id);
    }
}

