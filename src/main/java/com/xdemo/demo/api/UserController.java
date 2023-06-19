package com.xdemo.demo.api;

import com.fasterxml.jackson.annotation.JsonView;
import com.xdemo.demo.user.entity.User;
import com.xdemo.demo.user.service.UserService;
import com.xdemo.demo.utils.Views;
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
    @JsonView(Views.Response.class)
    public User get(@PathVariable int id) {
        return userService.getDtoById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userService.deleteById(id);
    }

    @PostMapping()
    @JsonView(Views.Response.class)
    public User add(@RequestBody
                    @JsonView(Views.Request.class) User user) {
        return userService.saveDto(user);
    }
}
