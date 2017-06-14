package com.belatrix.library.maintenance.resources;

import com.belatrix.library.maintenance.model.StatusModel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Kei Takayama
 * Created on 6/13/17.
 */

@Path("/status")
public class StatusRest {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStatus() {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();

        StatusModel statusModel = new StatusModel();
        statusModel.setMessage("UP");
        statusModel.setTime(dateTimeFormatter.format(localDateTime));

        return Response.ok().entity(statusModel).build();
    }

}
