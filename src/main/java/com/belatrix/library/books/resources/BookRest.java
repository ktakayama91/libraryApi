package com.belatrix.library.books.resources;

import com.belatrix.library.books.model.Book;
import com.belatrix.library.books.services.BookService;
import com.belatrix.library.books.services.BookServiceImpl;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

/**
 * Created by anthony on 6/14/17.
 */
@Path("books")
public class BookRest {

    private BookService bookService = new BookServiceImpl();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getBooks() {
        return Response.ok().entity(bookService.getBooks()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createBook(@Context UriInfo info, @Valid Book book){

        Integer id = bookService.createBook(book);
        URI uri = info.getRequestUriBuilder().path("{id}").build(id);
        return Response.created(uri).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response updateBook(Book book, @PathParam("id") Integer id) {
        try {
            bookService.updateBook(book, id);
            return Response.noContent().build();
        } catch (NotFoundException nfe) {
            return Response.status(Response.Status.NOT_FOUND).entity(nfe.getMessage()).build();
        } catch (IllegalArgumentException iae) {
            return Response.status(Response.Status.BAD_REQUEST).entity(iae.getMessage()).build();
        } catch (Exception e){
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBookById(@PathParam("id") Integer id){
        try{
            return Response.ok().entity(bookService.findBookById(id)).build();
        }catch (NotFoundException e){
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }catch (Exception e){
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBook(@PathParam("id") Integer id){
        try{
            bookService.deleteBook(id);
            return Response.noContent().build();
        }catch (NotFoundException e){
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }catch (Exception e){
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
