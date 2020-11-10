package se.iths.exception;

import se.iths.entity.Student;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.TEXT_PLAIN)
public class InvalidInputException extends WebApplicationException {

    public InvalidInputException(String message){
        super(Response.status(Response.Status.NOT_FOUND).entity(message).type(MediaType.TEXT_PLAIN).build());
    }

    public InvalidInputException() {

    }

}