package com.example.test.api;


import com.example.test.service.UserService;
import com.example.test.vo.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.test.entity.User;

import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("sign")
    public boolean sign(@RequestBody User user) {
        return userService.sign(user);
    }

    @PostMapping("login")
    public boolean login(@RequestBody Login login) {
        return userService.login(login);
    }

    @GetMapping("reset-password/{id}")
    public Map<String, String> resetPassword(@PathVariable("id") int id) {
        return userService.resetPassword(id);
    }

    @GetMapping("{id}")
    public User user(@PathVariable("id") int id) {
        return userService.get(id);
    }
}
