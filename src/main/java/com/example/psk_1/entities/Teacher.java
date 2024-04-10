package com.example.psk_1.entities;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    private String surname;

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.REMOVE)
    private List<Class> classes;

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }
}
