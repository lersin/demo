package org.onosproject.helloworld.rest;


import org.onosproject.net.helloworld.HelloWorldService;
import org.onosproject.rest.AbstractWebResource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("v1/hello")
public class HelloWorldResource extends AbstractWebResource {
    private final HelloWorldService helloWorldService = getService(HelloWorldService.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHelloWorld() {
        helloWorldService.sayHello("GET");
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response setHelloWorld() {
        helloWorldService.sayHello("POST");
        return Response.ok().build();
    }
}
