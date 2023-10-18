package com.example.demo.controllers;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Data
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String getAll() {
        return userService.getAll();
    }

    @PostMapping("/add")
    public String add(@RequestBody User user) {
        return userService.add(user);
    }

    @PostMapping("/delete")
    public void deleteById(@RequestBody User user) {
        userService.deleteById(user.getId());
    }

    @PostMapping("/find")
    public String findById(@RequestBody User user) {
        return userService.findById(user.getId());
    }

    @PostMapping("/getByRole")
    public String getByRole(@RequestBody Role role) {
        return userService.getByRoleId(role.getId());
    }
}
