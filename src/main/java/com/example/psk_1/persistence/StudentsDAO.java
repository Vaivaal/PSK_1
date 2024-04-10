package com.example.psk_1.persistence;

import com.example.psk_1.entities.Class;
import com.example.psk_1.entities.Student;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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

    public List<Student> getAvailable(Class selectedClass){
        TypedQuery<Student> query = entityManager.createQuery(
                "SELECT s FROM Student s WHERE :selectedClass NOT MEMBER OF s.attendedClasses", Student.class
        );
        query.setParameter("selectedClass", selectedClass);
        return query.getResultList();
    }
}
