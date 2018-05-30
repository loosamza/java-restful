package com.demo.service;

import com.demo.res.ResUser;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

// The Java class will be hosted at the URI path "/users"
@Path("/users")
public class UserResource {

  @Context
  private UriInfo context;

  public UserResource() {

  }

  // The Java method will process HTTP GET requests
  @GET
  // The Java method will produce content identified by the MIME Media type "text/plain"
  @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
  public List<ResUser> getJson() {
    // Return some cliched textual content
    List<ResUser> resUsers = new ArrayList<ResUser>();
    for (int i = 0; i < 2; i++) {
      ResUser resUser = new ResUser();
      resUser.setFirstname("First " + i + 1);
      resUser.setLastname("Last " + i + 1);
      resUser.setUsername("User " + i + 1);
      resUsers.add(resUser);
    }
    return resUsers;

  }

  @GET
  @Path("/me")
  @Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public ResUser getMe() {
    ResUser resUser = new ResUser();
    resUser.setFirstname("Piyapat");
    resUser.setLastname("Plydaung");
    resUser.setUsername("Piyapat.p");
    resUser.setBirhday(new Date(1994, 7, 30));

    return resUser;
  }

  @GET
  @Path("/{uid}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getId(@PathParam("uid") String uid) {

    if (uid.equalsIgnoreCase("user1")) {
      ResUser resUser = new ResUser();
      resUser.setFirstname("Piyapat");
      resUser.setLastname("Plydaung");
      resUser.setUsername("User 1");
      return Response.ok(resUser).build();
    }
    return Response.status(Status.FORBIDDEN).build();
  }


}
