package com.example.demo.controllers;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
@Data
public class RoleController {
    @Autowired
    private RoleService roleService;


    @GetMapping
    public String getAll() {
        return roleService.getAll();
    }

    @PostMapping("/add")
    public String add(@RequestBody Role role) {
        return roleService.add(role);
    }

    @PostMapping("/delete")
    public void deleteById(@RequestBody Role role) {
        roleService.deleteById(role.getId());
    }

    @PostMapping("/find")
    public String findById(@RequestBody User user) {
        return roleService.findById(user.getId());
    }
}
