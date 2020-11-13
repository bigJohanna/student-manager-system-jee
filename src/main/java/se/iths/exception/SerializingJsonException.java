package se.iths.exception;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.TEXT_PLAIN)
public class SerializingJsonException extends WebApplicationException {



}
