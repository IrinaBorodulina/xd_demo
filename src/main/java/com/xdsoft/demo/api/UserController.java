package com.xdsoft.demo.api;

import com.xdsoft.demo.user.entity.User;
import com.xdsoft.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User get(@PathVariable("id") Integer id) {
        return userService.getById(id);
    }

    @PostMapping()
    public User add(@RequestBody User user) {
        return userService.save(user);
    }
}
