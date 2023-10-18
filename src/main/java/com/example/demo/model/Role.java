package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "roles")
@Data
public class Role {
    @Id
    private int id;
    private String name;
}
