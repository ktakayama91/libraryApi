package com.belatrix.library.loans.resources;

import com.belatrix.library.loans.services.LoanService;
import com.belatrix.library.loans.services.LoanServiceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

}
