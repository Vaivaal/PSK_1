package com.example.psk_1.persistence;

import com.example.psk_1.entities.Class;
import com.example.psk_1.entities.Student;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.TypedQuery;
import java.util.List;
@Alternative
@ApplicationScoped
public class AlternativeStudentDAO implements IStudentsDAO{
    @Inject
    private EntityManager entityManager;

    @Override
    public void persist(Student student){
        entityManager.persist(student);
        System.out.println("Student persisted");
    }
    @Override
    public List<Student> getAll() {
        System.out.println("Getting all students...");
        return entityManager.createNamedQuery("Student.getAll", Student.class).getResultList();
    }
    @Override
    public Student getOne(Long id){
        System.out.println("Getting student...");
        return entityManager.find(Student.class, id, LockModeType.OPTIMISTIC);
    }
    @Override
    public Student update(Student student) {
        System.out.println("Updating student...");
        return entityManager.merge(student);
    }
    @Override
    public List<Student> getAvailable(Class selectedClass){
        TypedQuery<Student> query = entityManager.createQuery(
                "SELECT s FROM Student s WHERE :selectedClass NOT MEMBER OF s.attendedClasses", Student.class
        );
        query.setParameter("selectedClass", selectedClass);
        return query.getResultList();
    }
}
