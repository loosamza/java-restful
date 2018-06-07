package com.demo.res;

import java.util.Date;
import java.util.HashMap;

/**
 * @author piyapat.p on 7/6/2561.
 **/
public class CustomerManager {

  private static CustomerManager man;

  public static CustomerManager getInstance() {
    if (man == null) {
      man = new CustomerManager();
    }
    return man;
  }

  public HashMap<String, ResCustomer> dict;

  public CustomerManager() {
    dict = new HashMap<String, ResCustomer>();
    ResCustomer resCustomer;
    for (int i = 1; i <= 5; i++) {
      resCustomer = new ResCustomer();
      resCustomer.setFirstname("Piyapat" + i);
      resCustomer.setLastname("Plydaung" + i);
      resCustomer.setAddress("555");
      resCustomer.setPhone("083333333");
      resCustomer.setEmail("piyapatiii37" + i + "@gmail.com");
      dict.put(resCustomer.getFirstname(), resCustomer);
    }
  }

  public HashMap<String, ResCustomer> getDict() {
    return dict;
  }
}
