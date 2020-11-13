package se.iths.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper {

    @Override
    public Response toResponse(Throwable throwable) {
        return Response.status(Response.Status.BAD_REQUEST).entity("Aja baja").type(MediaType.TEXT_PLAIN).build();
    }
}
