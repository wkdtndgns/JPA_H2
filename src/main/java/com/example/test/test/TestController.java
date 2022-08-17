package com.example.test.test;

import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.test.entity.User;

import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    UserService userService;

    @PostMapping("sign")
    public boolean sign(@RequestBody User user) {
        return userService.sign(user);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<User> users() {
        return userService.findAll();
    }
}
