package com.apuntesdejava.jakartaee.ejb.resource;

import com.apuntesdejava.jakartaee.ejb.resource.request.DepartmentRequest;
import com.apuntesdejava.jakartaee.ejb.service.DepartmentService;
//import jakarta.ejb.EJB;
//import jakarta.ejb.Singleton;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import jakarta.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author Diego Silva (diego.silva@apuntesdejava.com)
 */
@Path("department")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
//@Singleton
@ApplicationScoped
public class DepartmentResource {

//    @EJB
    @Inject
    private DepartmentService departmentService;

    @GET
    public Response findAll() {
        var departmentsList = departmentService.findAll();
        return Response.ok(departmentsList).build();
    }

    @GET
    @Path("{id}")
    public Response findById(@PathParam("id") String id) {
        return departmentService.findById(id).map(department -> {
            return Response.ok(department).build();
        }).orElseGet(Response.status(Response.Status.NOT_FOUND)::build);
    }

    @POST
    public Response create(DepartmentRequest request) throws URISyntaxException {
        var department = departmentService.create(request.id(), request.name());
        return Response.created(new URI("department/%s".formatted(department.getId()))).build();
    }
}
