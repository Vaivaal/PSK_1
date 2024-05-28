package com.example.psk_1.persistence;

import com.example.psk_1.entities.Class;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@Specializes
@ApplicationScoped
public class SpecializesClassesDAO extends ClassesDAO{
    @Inject
    private EntityManager entityManager;

    public void persist (Class _class){
        System.out.println("SpecialClassesDAO: Persisting class with special behavior");
        entityManager.persist(_class);
    }
    public List<Class> getAll(){
        System.out.println("SpecialClassesDAO: Getting classes with special behavior");
        return entityManager.createNamedQuery("Class.getAll", Class.class).getResultList();
    }

    public Class getOne(Long id){
        System.out.println("SpecialClassesDAO: Getting class with special behavior");
        return entityManager.find(Class.class, id);
    }

    public Class update(Class _class){
        System.out.println("SpecialClassesDAO: Updating class with special behavior");
        return entityManager.merge(_class);
    }

    public void delete (Long id){
        System.out.println("SpecialClassesDAO: Deleting class with special behavior");
        Class _class = getOne(id);
        entityManager.remove(_class);
    }
}
