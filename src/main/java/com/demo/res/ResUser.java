package com.demo.res;

import java.util.Date;

public class ResUser {

  private String username;
  private String firstname;
  private String lastname;
  private Date birhday;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public Date getBirhday() {
    return birhday;
  }

  public void setBirhday(Date birhday) {
    this.birhday = birhday;
  }
}
