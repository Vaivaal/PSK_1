package com.example.psk_1.persistence;

import com.example.psk_1.entities.Class;
import com.example.psk_1.entities.Student;
import com.example.psk_1.entities.Teacher;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class TeacherDAO {
    @Inject
    private EntityManager entityManager;
    public Teacher getOne(Long id){
        return entityManager.find(Teacher.class, id);
    }

    public List<Teacher> getAvailable(Class selectedClass){
        TypedQuery<Teacher> query = entityManager.createQuery(
                "SELECT s FROM Teacher s WHERE :selectedClass NOT MEMBER OF s.classes", Teacher.class
        );
        query.setParameter("selectedClass", selectedClass);
        return query.getResultList();
    }
}
