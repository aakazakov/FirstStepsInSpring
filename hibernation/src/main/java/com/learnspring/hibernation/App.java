package com.learnspring.hibernation;

import com.learnspring.hibernation.domain.Buyer;

public class App {
  
  public static void main(String[] args) {
    
    Administrator admin = new Administrator();
    
    Buyer buyer = new Buyer();
    buyer.setName("John");
    
    admin.createEntity(buyer);
    
    admin.close();
    
  }
  
}
