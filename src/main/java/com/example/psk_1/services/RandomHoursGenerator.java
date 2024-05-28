package com.example.psk_1.services;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.Random;

@ApplicationScoped
public class RandomHoursGenerator implements Serializable {
    public Integer generateHoursPerWeek(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Random().nextInt(10);
    }
}
