package com.example.psk_1.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Entity
@EqualsAndHashCode
@NamedQueries({
        @NamedQuery(name = "Student.getAll", query = "SELECT s FROM Student as s")
})
public class Student implements Serializable {

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

    @Basic(optional = false)
    private String surname;

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @ManyToMany
    private List<Class> attendedClasses;

    public void setAttendedClasses(List<Class> attendedClasses) {
        this.attendedClasses = attendedClasses;
    }
}
