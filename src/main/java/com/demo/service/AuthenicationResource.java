package com.demo.service;

import com.demo.res.ResLogin;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * @author piyapat.p on 7/6/2561.
 **/
@Path("authentication")
public class AuthenicationResource {

  private static final Logger LOG = Logger.getLogger(AuthenicationResource.class.getName());

  @Context
  private UriInfo context;

  public AuthenicationResource() {
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  public Response postLogin(@FormParam("username") String username,
      @FormParam("password") String password
  ) {
    NewCookie newCookie = new NewCookie("DeeUser", username, "/", null, null, -1, false, true);
    return Response.ok("{\"token\":\"" + username + "\"}").cookie(newCookie).build();
  }

  @POST
  @Path("logout")
  public Response postLogout() {
    NewCookie newCookie = new NewCookie("DeeUser", "", "/", null, null, -1, false, true);
    return Response.ok("{\"token\":\"\"}").cookie(newCookie).build();
  }
}
