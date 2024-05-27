package com.example.psk_1.rest;

import com.example.psk_1.entities.Class;
import com.example.psk_1.persistence.ClassesDAO;
import com.example.psk_1.rest.DTO.ClassDto;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/classes")
public class ClassController {
    @Inject
    @Getter @Setter
    private ClassesDAO classesDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Long id){
        Class _class = classesDAO.getOne(id);
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println(id);
        if (_class == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        ClassDto classDto = new ClassDto();
        classDto.setName(_class.getName());
        classDto.setHoursPerWeek(_class.getHoursPerWeek());
        if (_class.getTeacher() != null)
            classDto.setTeacherName(_class.getTeacher().getName());

        return Response.ok(classDto).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") final Long classId, ClassDto classDto){
        try{
            Class existingClass = classesDAO.getOne(classId);
            if(existingClass == null){
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingClass.setName(classDto.getName());
            existingClass.setHoursPerWeek(classDto.getHoursPerWeek());
            classesDAO.update(existingClass);
            return Response.ok().build();
        }catch (OptimisticLockException e){
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(ClassDto classDto){
        Class newClass = new Class();
        newClass.setName(classDto.getName());
        newClass.setHoursPerWeek(classDto.getHoursPerWeek());
        classesDAO.persist(newClass);
        return Response.status(Response.Status.CREATED).entity(newClass).build();
    }
}
