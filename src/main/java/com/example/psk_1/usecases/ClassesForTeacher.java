package com.example.psk_1.usecases;

import com.example.psk_1.mybatis.dao.TeacherMapper;
import com.example.psk_1.entities.Teacher;
import com.example.psk_1.persistence.TeacherDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.Map;

@Model
public class ClassesForTeacher {
    @Inject
    private TeacherDAO teacherDAO;

    @Getter @Setter
    private Teacher teacher;

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long teacherId = Long.parseLong(requestParameters.get("teacherId"));
        teacher = teacherDAO.getOne(teacherId);
    }

}
