package se.iths.rest;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;
import se.iths.exception.NotFoundException;
import se.iths.service.TeacherService;
import se.iths.validator.InputValidator;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Set;

@Path("teacher")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeacherRest {


    @Inject
    TeacherService teacherService;

    @Inject
    InputValidator inputValidator;

    @Path("add")
    @POST
    public Response addTeacher(Teacher teacher) {
        inputValidator.validateTeacherInput(teacher);
        Teacher newTeacher = teacherService.createTeacher(teacher);
        return Response.ok(newTeacher).build();
    }

    @Path("{id}")
    @GET
    public Response getTeacher(@PathParam("id") Long id) {
        Teacher foundTeacher = findTeacher(id);
        return Response.ok(foundTeacher).build();
    }


    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    @DELETE
    public Response deleteTeacherById(@PathParam("id") Long id) {
        findTeacher(id);
        teacherService.deleteTeacher(id);
        return Response.ok().build();
    }

    @Path("update")
    @PUT
    public Response updateTeacher(Teacher teacher) {
        findTeacher(teacher.getId());
        teacherService.updateTeacher(teacher);
        return Response.ok(teacher).build();
    }

    @Path("all")
    @GET
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    private Teacher findTeacher(Long id){
        Teacher foundTeacher = teacherService.findTeacherById(id);
        if (foundTeacher == null)
            throw new NotFoundException(id);
        return foundTeacher;
    }

    @Path("subjects/{teacherId}")
    @GET
    public Set<Subject> getSubjectsByeacherId(@PathParam("teacherId") Long id){

        findTeacher(id);
        return teacherService.getAllSubjects(id);
    }

    ///students/{teacher-id}/{subject-id} <br>
    //All students by teacher ID and subject ID

    @Path("students/{teacher-id}/{subject-id}")
    @GET
    public Set<Student> getStudentsByTeacherIdAndSubjectId(
            @PathParam("teacher-id") Long teacherId,
            @PathParam("subject-id") Long subjectId){
        findTeacher(teacherId);
        return teacherService.getStudentsByTeacherAndSubject(teacherId, subjectId);
    }
}