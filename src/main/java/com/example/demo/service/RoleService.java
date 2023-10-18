package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public String getAll() {
        try {
            return GetResultAsTable.getResultAsTable(roleRepository.findAll());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "Error. Try again";
        }
    }

    public String add(Role role) {
        try {
            return GetResultAsTable.getResultAsTable(roleRepository.save(role));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "Error. Try again";
        }
    }

    public String findById(Integer id) {
        try {
            return GetResultAsTable.getResultAsTable(roleRepository.findById(id).get());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "Error. Try again";
        }
    }

    public void deleteById(Integer id) {
        roleRepository.deleteById(id);
    }
}
