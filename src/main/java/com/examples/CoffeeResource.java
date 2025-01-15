package com.examples;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/coffee")
public class CoffeeResource {

    @Inject
    CoffeeService coffeeService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getCoffee() {
        return coffeeService.getCoffee();
    }
}
