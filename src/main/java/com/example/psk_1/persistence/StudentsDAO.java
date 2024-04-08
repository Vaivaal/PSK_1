package com.example.psk_1.persistence;

import com.example.psk_1.entities.Student;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class StudentsDAO {
    @Inject
    private EntityManager entityManager;

    public void persist(Student student){
        entityManager.persist(student);
    }
    public List<Student> getAll() {
        return entityManager.createNamedQuery("Student.getAll", Student.class).getResultList();
    }

    public Student getOne(Long id){
        return entityManager.find(Student.class, id);
    }

    public Student update(Student student){return entityManager.merge(student);}
}
