package com.example.psk_1.rest.DTO;

import com.example.psk_1.entities.Teacher;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;

@Getter @Setter
public class ClassDto {
    private String name;

    private Integer hoursPerWeek;

    private String TeacherName;
}
