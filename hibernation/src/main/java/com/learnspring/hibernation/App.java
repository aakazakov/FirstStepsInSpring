package com.learnspring.hibernation;

import com.learnspring.hibernation.domain.Buyer;

public class App {
  
  public static void main(String[] args) {
    
    Administrator admin = new Administrator();
    
    Buyer buyer = new Buyer("John");
    admin.create(buyer);
    
    buyer = new Buyer("Mary");
    admin.save(buyer);
    
    buyer = new Buyer("Bill");
    admin.save(buyer);
    
    admin.close();
    
  }
  
}
