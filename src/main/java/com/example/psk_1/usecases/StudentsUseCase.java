package com.example.psk_1.usecases;

import com.example.psk_1.entities.Student;
import com.example.psk_1.persistence.StudentsDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class StudentsUseCase {
    @Inject
    private StudentsDAO studentsDAO;

    @Getter @Setter
    private Student studentToCreate = new Student();

    @Getter
    private List<Student> allStudents;

    @PostConstruct
    public void init(){findAllStudents();}

    @Transactional
    public void createStudent() {
        studentsDAO.persist(studentToCreate);
    }

    private void findAllStudents(){
        allStudents = studentsDAO.getAll();
    }
}
