package com.belatrix.library.loans.resources;

import com.belatrix.library.loans.model.Loan;
import com.belatrix.library.loans.services.LoanService;
import com.belatrix.library.loans.services.LoanServiceImpl;
import com.belatrix.library.maintenance.model.ErrorModel;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

/**
 * @author Kei Takayama
 * Created on 6/17/17.
 */

@Path("loans")
public class LoanRest {

    private LoanService loanService = new LoanServiceImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLoans() {
        return Response.ok().entity(loanService.getLoans()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createLoans(@Context UriInfo info, @Valid Loan loan){

        try {
            Integer id = loanService.createLoan(loan);
            URI uri = info.getRequestUriBuilder().path("{id}").build(id);
            return Response.created(uri).build();
        } catch (NotFoundException nfe) {
            return Response.status(Response.Status.NOT_FOUND).entity(new ErrorModel(null, nfe.getMessage())).build();
        } catch (IllegalArgumentException iae) {
            return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorModel(null, iae.getMessage())).build();
        } catch (Exception e){
            return Response.serverError().entity(new ErrorModel(null, e.getMessage())).build();
        }
    }

}
