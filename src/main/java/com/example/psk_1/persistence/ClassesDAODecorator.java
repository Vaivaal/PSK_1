package com.example.psk_1.persistence;

import com.example.psk_1.entities.Class;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import java.util.List;

@Decorator
public class ClassesDAODecorator implements IClassesDAO{
    @Inject
    @Delegate
    private IClassesDAO classesDAO;

    @Override
    public void persist(Class _class) {
        System.out.println("ClassesDAODecorator: Before persisting class");
        classesDAO.persist(_class);
        System.out.println("ClassesDAODecorator: After persisting class");
    }

    @Override
    public List<Class> getAll() {
        System.out.println("ClassesDAODecorator: Before getting all classes");
        List<Class> classes = classesDAO.getAll();
        System.out.println("ClassesDAODecorator: After getting all classes");
        return classes;
    }

    @Override
    public Class getOne(Long id) {
        System.out.println("ClassesDAODecorator: Before getting class");
        Class _class = classesDAO.getOne(id);
        System.out.println("ClassesDAODecorator: After getting class");
        return _class;
    }

    @Override
    public Class update(Class _class) {
        System.out.println("ClassesDAODecorator: Before updating class");
        Class updatedClass = classesDAO.update(_class);
        System.out.println("ClassesDAODecorator: After updating class");
        return updatedClass;
    }

    @Override
    public void delete(Long id) {
        System.out.println("ClassesDAODecorator: Before deleting class");
        classesDAO.delete(id);
        System.out.println("ClassesDAODecorator: After deleting class");
    }
}
