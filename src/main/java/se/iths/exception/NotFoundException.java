package se.iths.exception;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.TEXT_PLAIN)
public class NotFoundException extends WebApplicationException {

    public NotFoundException(Long id){
        super(Response.status(Response.Status.NOT_FOUND).entity("Object with id '" + id + "' not found.").type(MediaType.TEXT_PLAIN).build());
    }

}
