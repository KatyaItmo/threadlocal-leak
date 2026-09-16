package ru.itmo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/process")
public class Process {
    private static final ThreadLocal<byte[]> threadMemory = new ThreadLocal<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response processData() {
        byte[] data = new byte[10485760];
        threadMemory.set(data);

        return Response.ok("{\"message\": \"processed\"}").build();
    }
}
