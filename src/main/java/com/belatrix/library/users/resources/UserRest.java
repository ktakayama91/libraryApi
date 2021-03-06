package com.belatrix.library.users.resources;

import com.belatrix.library.maintenance.model.ErrorModel;
import com.belatrix.library.users.model.User;
import com.belatrix.library.users.services.UserService;
import com.belatrix.library.users.services.UserServiceImpl;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

/**
 * @author Kei Takayama
 * Created on 6/13/17.
 */

@Path("users")
public class UserRest {

    private UserService userService = new UserServiceImpl();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getUsers() {
        return Response.ok().entity(userService.getUsers()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(@Context UriInfo info, @Valid User user){

        Integer id = userService.createUser(user);
        URI uri = info.getRequestUriBuilder().path("{id}").build(id);
        return Response.created(uri).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("id") Integer id) {

        try {
            return Response.ok().entity(userService.findUserById(id)).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new ErrorModel(null, e.getMessage())).build();
        } catch (Exception e) {
            return Response.serverError().entity(new ErrorModel(null, e.getMessage())).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") Integer id, @Valid User user) {

        try {
            userService.updateUser(user, id);
            return Response.noContent().build();
        } catch (NotFoundException nfe) {
            return Response.status(Response.Status.NOT_FOUND).entity(new ErrorModel(null, nfe.getMessage())).build();
        } catch (IllegalArgumentException iae) {
            return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorModel(null, iae.getMessage())).build();
        } catch (Exception e){
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") Integer id) {

        try {
            userService.deleteUser(id);
            return Response.noContent().build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new ErrorModel(null, e.getMessage())).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
