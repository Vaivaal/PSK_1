package com.example.psk_1.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter @Setter
@Entity
@NamedQueries({
        @NamedQuery(name = "Class.getAll", query = "SELECT c FROM Class as c")
})
public class Class implements Serializable {

    @Version
    private Long version;

    @Id
    @GeneratedValue
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Basic(optional = false)
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    private Integer hoursPerWeek;

    public void setHoursPerWeek(Integer hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    @ManyToOne(cascade = CascadeType.REMOVE)
    private Teacher teacher;

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @ManyToMany(mappedBy = "attendedClasses", cascade = CascadeType.REMOVE)
    private List<Student> students;

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
