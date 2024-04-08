package com.example.psk_1.persistence;

import com.example.psk_1.entities.Class;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ClassesDAO {
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
}
