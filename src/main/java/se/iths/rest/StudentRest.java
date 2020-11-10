package se.iths.rest;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import se.iths.entity.Student;
import se.iths.exception.InvalidInputException;
import se.iths.exception.NotFoundException;
import se.iths.service.StudentService;

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

    @Path("add")
    @POST
    public Response addStudent(@Valid @RequestBody Student student) {

        if(student.getFirstName() == null || student.getLastname() == null || student.getEmail() == null){
            String message = createMessage(student);
            throw new InvalidInputException(message);
        }

        Student newStudent = studentService.createStudent(student);
        return Response.ok(newStudent).build();
    }

    @Path("{id}")
    @GET
    public Response getStudent(@PathParam("id") Long id) {
        Student foundStudent = studentService.findStudentById(id);
        if (foundStudent == null)
            throw new NotFoundException(id);
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
        Student foundStudent = studentService.findStudentById(id);
        if (foundStudent != null) {
            studentService.deleteStudent(id);
            return Response.ok().build();
        }
        throw new NotFoundException(id);
    }

    @Path("update")
    @PUT
    public Response updateStudent(Student student) {
        studentService.updateStudent(student);
        return Response.ok().build();
    }

    @Path("all")
    @GET
    public List<Student> getAllItems() {
        return studentService.getAllStudents();
    }

    private String createMessage(Student student) {
        StringBuilder message = new StringBuilder();
        if(student.getFirstName() == null){
            message.append("First name must be specified \n");
        }
        if(student.getLastname() == null){
            message.append("Lastname must be specified \n");
        }
        if(student.getEmail() == null){
            message.append("Email must be specified \n");
        }
        return message.toString();
    }

}
