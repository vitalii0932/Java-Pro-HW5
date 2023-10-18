package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String getAll() {
        try {
            return GetResultAsTable.getResultAsTable(userRepository.findAll());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "Error. Try again";
        }
    }

    public String add(User user) {
        try {
            return GetResultAsTable.getResultAsTable(userRepository.save(user));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "Error. Try again";
        }
    }

    public String findById(Integer id) {
        try {
            return GetResultAsTable.getResultAsTable(userRepository.findById(id).get());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "Error. Try again";
        }
    }

    public String getByRoleId(Integer roleId) {
        try {
            return GetResultAsTable.getResultAsTable(userRepository.getUserByRoleId(roleId));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "Error. Try again";
        }
    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }
}
