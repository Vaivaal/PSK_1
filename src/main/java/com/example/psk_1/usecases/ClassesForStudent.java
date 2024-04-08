package com.example.psk_1.usecases;

import com.example.psk_1.entities.Class;
import com.example.psk_1.entities.Student;
import com.example.psk_1.persistence.ClassesDAO;
import com.example.psk_1.persistence.StudentsDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.Map;

@Model
public class ClassesForStudent {
    @Inject
    private StudentsDAO studentsDAO;


    @Getter
    @Setter
    private Student student;


    @PostConstruct
    public void init(){
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long studentId = Long.parseLong(requestParameters.get("studentId"));
        student = studentsDAO.getOne(studentId);
    }
}
