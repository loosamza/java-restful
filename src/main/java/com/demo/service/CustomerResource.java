package com.demo.service;

import com.demo.res.ResCustomer;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author piyapat.p on 7/6/2561.
 **/
public class CustomerResource {

  private String id;

  public CustomerResource(String id) {
    this.id = id;
  }

  public static CustomerResource getInstance(String id) {
    return new CustomerResource(id);
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public ResCustomer getJson() {
    return null;
  }

  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  public void putJson(ResCustomer content) {

  }

  @DELETE
  public void delete() {

  }
}
