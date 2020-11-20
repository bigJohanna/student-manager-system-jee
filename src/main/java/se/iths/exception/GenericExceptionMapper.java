package se.iths.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable arg) {
        return Response.status(Response.Status.BAD_REQUEST).entity("Something went wrong").type(MediaType.TEXT_PLAIN).build();
    }
}
