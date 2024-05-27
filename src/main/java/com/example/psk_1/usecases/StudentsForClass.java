package com.example.psk_1.usecases;

import com.example.psk_1.entities.Class;
import com.example.psk_1.entities.Student;
import com.example.psk_1.interceptors.LoggedInvocation;
import com.example.psk_1.mybatis.dao.TeacherMapper;
import com.example.psk_1.persistence.ClassesDAO;
import com.example.psk_1.persistence.IClassesDAO;
import com.example.psk_1.persistence.IStudentsDAO;
import com.example.psk_1.persistence.StudentsDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@ViewScoped
@Named
@Getter @Setter
public class StudentsForClass implements Serializable {
    @Inject
    private IStudentsDAO studentsDAO;

    @Inject
    private IClassesDAO classesDAO;

    @Getter
    @Setter
    private Student selectedStudent;

    @Getter @Setter
    private Long studentId;

    @Getter @Setter
    private Class classToAddTo;

    @Getter @Setter
    private List<Student> notSelectedStudents;

    @Getter @Setter
    private String errorMessage;


    @PostConstruct
    public void init(){
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long classId = Long.parseLong(requestParameters.get("classId"));
        classToAddTo = classesDAO.getOne(classId);
        notSelectedStudents = studentsDAO.getAvailable(classToAddTo);
    }

    @Transactional
    public void addStudentsToClass(){
        selectedStudent = studentsDAO.getOne(studentId);
        selectedStudent.getAttendedClasses().add(classToAddTo);
        studentsDAO.update(this.selectedStudent);
    }

    @Transactional
    @LoggedInvocation
    public void updateClassName(){
        try{
            classesDAO.update(classToAddTo);
            //TimeUnit.SECONDS.sleep(5);
        }catch (OptimisticLockException e){
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            errorMessage = "Optimistic lock exception: " + e;
        }
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }

}
