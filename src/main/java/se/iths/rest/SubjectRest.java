package se.iths.rest;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.exception.NotFoundException;
import se.iths.service.SubjectService;
import se.iths.validator.InputValidator;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Set;

@Path("subject")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SubjectRest {


    @Inject
    SubjectService subjectService;

    @Inject
    InputValidator inputValidator;

    @Path("add")
    @POST
    public Response addSubject(Subject subject) {
        inputValidator.validateSubjectInput(subject);
        Subject newSubject = subjectService.createSubject(subject);
        return Response.ok(newSubject).build();
    }

    @Path("{id}")
    @GET
    public Response getSubject(@PathParam("id") Long id) {
        Subject foundSubject = findSubject(id);
        return Response.ok(foundSubject).build();
    }


    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    @DELETE
    public Response deleteSubjectById(@PathParam("id") Long id) {
        findSubject(id);
        subjectService.deleteSubject(id);
        return Response.ok().build();
    }

    @Path("update")
    @PUT
    public Response updateSubject(Subject subject) {
        findSubject(subject.getId());
        subjectService.updateSubject(subject);
        return Response.ok(subject).build();
    }

    @Path("all")
    @GET
    public List<Subject> getAllItems() {
        return subjectService.getAllSubjects();
    }

    private Subject findSubject(Long id){
        Subject foundSubject = subjectService.findSubjectById(id);
        if (foundSubject == null)
            throw new NotFoundException(id);
        return foundSubject;
    }

    @Path("students/{subject-id}")
    @GET
    public Set<Student> getStudentsBySubjectId(@PathParam("subject-id") Long id){
        findSubject(id);
        return subjectService.studentsBySubjectId(id);
    }

}