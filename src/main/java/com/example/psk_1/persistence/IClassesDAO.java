package com.example.psk_1.persistence;

import com.example.psk_1.entities.Class;

import java.util.List;

public interface IClassesDAO {
    void persist (Class _class);
    List<Class> getAll();
    Class getOne(Long id);
    Class update(Class _class);
    void delete (Long id);
}
