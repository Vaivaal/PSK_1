package com.example.psk_1.persistence;

import com.example.psk_1.entities.Class;
import com.example.psk_1.entities.Student;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ClassesDAO implements IClassesDAO {
    @Inject
    private EntityManager entityManager;

    public void persist (Class _class){
        entityManager.persist(_class);
    }
    public List<Class> getAll(){
        return entityManager.createNamedQuery("Class.getAll", Class.class).getResultList();
    }

    public Class getOne(Long id){
        return entityManager.find(Class.class, id);
    }
    public Class update(Class _class){return entityManager.merge(_class);}

    public void delete (Long id){
        Class _class = getOne(id);
        entityManager.remove(_class);
    }
}
