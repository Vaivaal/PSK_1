package com.example.psk_1.usecases;

import com.example.psk_1.entities.Class;
import com.example.psk_1.entities.Student;
import com.example.psk_1.persistence.ClassesDAO;
import com.example.psk_1.persistence.StudentsDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Model
public class StudentsForClass implements Serializable {
    @Inject
    private StudentsDAO studentsDAO;

    @Inject
    private ClassesDAO classesDAO;

    @Getter
    @Setter
    private Student selectedStudent;

    @Getter @Setter
    private Long studentId;

    @Getter @Setter
    private Class classToAddTo;

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long classId = Long.parseLong(requestParameters.get("classId"));
        classToAddTo = classesDAO.getOne(classId);
        //System.out.println(classToAddTo.getName());
    }

    @Transactional
    public void addStudentsToClass(){
        selectedStudent = studentsDAO.getOne(studentId);

//        List<Class> attendedClasses = selectedStudent.getAttendedClasses();
//        attendedClasses.add(classToAddTo);
//        selectedStudent.setAttendedClasses(attendedClasses);

        selectedStudent.getAttendedClasses().add(classToAddTo);
        studentsDAO.update(selectedStudent);
    }

}
