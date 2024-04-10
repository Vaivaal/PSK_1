package com.example.psk_1.usecases;

import com.example.psk_1.mybatis.dao.TeacherMapper;
import com.example.psk_1.mybatis.model.Teacher;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class TeachersUseCase {
    @Inject
    private TeacherMapper teacherMapper;
    @Getter
    private List<Teacher> allTeachers;

    @Getter @Setter
    private Teacher teacherToCreate = new Teacher();

    @PostConstruct
    public void init(){
        loadAllTeachers();
    }

    private void loadAllTeachers(){
        allTeachers = teacherMapper.selectAll();
    }

    @Transactional
    public String createTeacher(){
        teacherMapper.insert(teacherToCreate);
        return "classTeachers?faces-redirect=true";
    }
}
