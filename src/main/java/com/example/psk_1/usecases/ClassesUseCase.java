package com.example.psk_1.usecases;

import com.example.psk_1.entities.Class;
import com.example.psk_1.persistence.ClassesDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class ClassesUseCase {
    @Inject
    ClassesDAO classesDAO;

    @Getter
    @Setter
    private Class classToCreate = new Class();

    @Getter
    private List<Class> allClasses;

    @PostConstruct
    public void init(){findAllClasses();}
    @Transactional
    public void createClass (){
        classesDAO.persist(classToCreate);
    }

    private void findAllClasses(){allClasses = classesDAO.getAll();}
}
