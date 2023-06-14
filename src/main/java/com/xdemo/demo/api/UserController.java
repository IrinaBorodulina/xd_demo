package com.xdemo.demo.api;

import com.xdemo.demo.user.dto.UserDto;
import com.xdemo.demo.user.service.UserService;
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
    public UserDto get(@PathVariable int id) {
        return userService.getDtoById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userService.deleteById(id);
    }

    @PostMapping()
    public UserDto add(@RequestBody UserDto userDto) {
        return userService.saveDto(userDto);
    }
}
