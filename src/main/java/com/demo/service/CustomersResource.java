package com.demo.service;

import com.demo.res.ResCustomer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * @author piyapat.p on 7/6/2561.
 **/
@Path("/customers")
@RolesAllowed({"Admins"})
public class CustomersResource {

  @Context
  private UriInfo context;

  public CustomersResource() {
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<ResCustomer> getJson() {
    List<ResCustomer> resCustomers = new ArrayList<ResCustomer>();
    ResCustomer resCustomer = new ResCustomer();
    resCustomer.setFirstname("Piyapat");
    resCustomer.setLastname("Plydaung");
    resCustomer.setAddress("555");
    resCustomer.setPhone("083333333");
    resCustomer.setEmail("piyapatiii37" + "@gmail.com");
    resCustomers.add(resCustomer);
    return resCustomers;
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response postJson(ResCustomer content) {
    return Response.created(context.getAbsolutePath()).build();
  }

  @Path("{id}")
  public CustomerResource getCustomerResource(@PathParam("id") String id) {
    return CustomerResource.getInstance(id);
  }
}
