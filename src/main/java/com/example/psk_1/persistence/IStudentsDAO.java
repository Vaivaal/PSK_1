package com.example.psk_1.persistence;

import com.example.psk_1.entities.Class;
import com.example.psk_1.entities.Student;

import javax.persistence.LockModeType;
import java.util.List;

public interface IStudentsDAO {
    void persist(Student student);
    List<Student> getAll();
    Student getOne(Long id);
    Student update(Student student);
    List<Student> getAvailable(Class selectedClass);
}
