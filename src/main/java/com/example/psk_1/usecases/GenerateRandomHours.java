package com.example.psk_1.usecases;

import com.example.psk_1.services.RandomHoursGenerator;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class GenerateRandomHours implements Serializable {
    @Inject
    RandomHoursGenerator randomHoursGenerator;
    private CompletableFuture<Integer> randomHoursGenerationTask = null;
    public void generateNewHoursPerWeek(){
        randomHoursGenerationTask = CompletableFuture.supplyAsync(() -> randomHoursGenerator.generateHoursPerWeek());
    }

    public String getHourGenerationStatus() throws ExecutionException, InterruptedException{
        if(randomHoursGenerationTask == null){
            return null;
        }else if (!randomHoursGenerationTask.isDone()){
            return "Hour Per Week generation in progress";
        }
        return "Generated hours per week: " + randomHoursGenerationTask.get();
    }
}
