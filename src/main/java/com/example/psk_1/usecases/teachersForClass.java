package com.example.psk_1.usecases;

import com.example.psk_1.entities.Class;
import com.example.psk_1.entities.Student;
import com.example.psk_1.mybatis.dao.TeacherMapper;
import com.example.psk_1.entities.Teacher;
import com.example.psk_1.persistence.ClassesDAO;
import com.example.psk_1.persistence.StudentsDAO;
import com.example.psk_1.persistence.TeacherDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Model
public class teachersForClass {
    @Inject
    private TeacherMapper teacherMapper;

    @Inject
    private TeacherDAO teacherDAO;
    @Inject
    private ClassesDAO classesDAO;

    @Getter
    @Setter
    private Class classToAddTo;

    @Getter
    @Setter
    private Teacher selectedTeacher;

    @Getter @Setter
    private Long teacherId;

    @Getter @Setter
    private List<Teacher> notSelectedTeachers;


    @PostConstruct
    public void init(){
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long classId = Long.parseLong(requestParameters.get("classId"));
        classToAddTo = classesDAO.getOne(classId);
        notSelectedTeachers = teacherDAO.getAvailable(classToAddTo);
    }

    @Transactional
    public void addTeacherToClass(){
        selectedTeacher = mapTeacher(teacherMapper.selectByPrimaryKey(teacherId));
        classToAddTo.setTeacher(selectedTeacher);
        classesDAO.update(classToAddTo);
    }

    private Teacher mapTeacher(com.example.psk_1.mybatis.model.Teacher myBatisTeacher){
        Teacher teacher = new Teacher();
        teacher.setId(myBatisTeacher.getId());
        teacher.setName(myBatisTeacher.getName());
        teacher.setSurname(myBatisTeacher.getSurname());
        return teacher;
    }
}
