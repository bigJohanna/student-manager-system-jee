package se.iths.rest;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import se.iths.entity.Student;
import se.iths.exception.InvalidInputException;
import se.iths.exception.NotFoundException;
import se.iths.service.StudentService;
import se.iths.validator.InputValidator;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("student")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentRest {

    @Inject
    StudentService studentService;

    @Inject
    InputValidator inputValidator;

    @Path("add")
    @POST
    public Response addStudent(@Valid @RequestBody Student student) {
            inputValidator.validateStudentInput(student);
            Student newStudent = studentService.createStudent(student);
            return Response.ok(newStudent).build();
    }

    @Path("{id}")
    @GET
    public Response getStudent(@PathParam("id") Long id) {
        Student foundStudent = findStudent(id);
        return Response.ok(foundStudent).build();
    }

    @Path("lastname")
    @GET
    public List<Student> getStudentByLastname(@QueryParam("lastname") String lastname) {
        return studentService.findStudentByLastname(lastname);
    }

    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    @DELETE
    public Response deleteStudentById(@PathParam("id") Long id) {
            findStudent(id);
            studentService.deleteStudent(id);
            return Response.ok().build();
    }

    @Path("update")
    @PUT
    public Response updateStudent(Student student) {
        findStudent(student.getId());
        studentService.updateStudent(student);
        return Response.ok(student).build();
    }

    @Path("all")
    @GET
    public List<Student> getAllItems() {
        return studentService.getAllStudents();
    }

    private Student findStudent(Long id){
        Student foundStudent = studentService.findStudentById(id);
        if (foundStudent == null)
            throw new NotFoundException(id);
        return foundStudent;
    }

}
