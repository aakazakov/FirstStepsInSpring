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
    
    // Tom's shopping
    Buyer buyer = admin.read(Buyer.class, 1L);
    Product product = admin.read(Product.class, 4L);
    buyer.getProducts().add(product);
    product = admin.read(Product.class, 5L);
    buyer.getProducts().add(product);
    product = admin.read(Product.class, 6L);
    buyer.getProducts().add(product);
    product = admin.read(Product.class, 7L);
    buyer.getProducts().add(product);
    product = admin.read(Product.class, 13L);
    buyer.getProducts().add(product);
    admin.save(buyer);
    
    // John's shopping
    buyer = admin.read(Buyer.class, 2L);
    product = admin.read(Product.class, 7L);
    buyer.getProducts().add(product);
    product = admin.read(Product.class, 13L);
    buyer.getProducts().add(product);
    admin.save(buyer);
    
    // Mary's shopping
    buyer = admin.read(Buyer.class, 3L);
    product = admin.read(Product.class, 8L);
    buyer.getProducts().add(product);
    product = admin.read(Product.class, 9L);
    buyer.getProducts().add(product);
    product = admin.read(Product.class, 10L);
    buyer.getProducts().add(product);
    product = admin.read(Product.class, 11L);
    buyer.getProducts().add(product);
    product = admin.read(Product.class, 13L);
    buyer.getProducts().add(product);
    admin.save(buyer);
    
    // orders
    admin.displayOrderList(1L);
    admin.displayOrderList(2L);
    admin.displayOrderList(3L);
    
    // statistics
    admin.displayBuyerList(13L);
    admin.displayBuyerList(9L);
    admin.displayBuyerList(11L);
    admin.displayBuyerList(7L);
    admin.displayBuyerList(12L);
    
    //delete
    int del1 = admin.delete(Product.class, 13L);
    int del2 = admin.delete(Buyer.class, 2L);
    System.out.println(del1);
    System.out.println(del2);
       
    admin.close();
    
  }
  
}
