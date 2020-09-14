package com.learnspring.hibernation;

import com.learnspring.hibernation.domain.Buyer;
import com.learnspring.hibernation.domain.Product;

public class App {
  
  public static void main(String[] args) {
    
    Administrator admin = new Administrator();
    
    admin.create(new Buyer("Tom"));
    admin.save(new Buyer("John"));
    admin.save(new Buyer("Mary"));
    
    admin.create(new Product("Tea", 100.0));
    admin.save(new Product("Coffee", 150.0));
    admin.save(new Product("Orange juce", 120.0));
    admin.save(new Product("Red Bull", 115.0));
    admin.save(new Product("Coca-Cola", 110.0));
    admin.save(new Product("Ice cream", 50.0));
    admin.save(new Product("Cake", 70.0));
    admin.save(new Product("Milk", 40.0));
    admin.save(new Product("Water", 10.0));
    admin.save(new Product("Chocolate", 10.0));
    
  }
  
}
