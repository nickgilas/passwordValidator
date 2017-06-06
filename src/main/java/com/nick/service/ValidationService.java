package com.nick.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nick.validator.PasswordValidator;
import com.nick.validator.ValidationResponse;

@Component
@Path( "/validation" )
public class ValidationService {

    @Autowired
    private PasswordValidator passwordValidator;

    @GET 
    @Path("/echo") 
    public Response echo() {
    	return Response.status(200).entity("Hello").build();
    }
    
    @GET
    @Path( "/password/{password}" )
    public Response validatePassword(@PathParam(value = "password") String password) {

        try {
            ValidationResponse result = passwordValidator.isValid(password);

            return Response.status(200).entity(result).build();

        } catch (Throwable t) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

    }
}
