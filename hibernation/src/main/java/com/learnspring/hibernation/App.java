package com.learnspring.hibernation;

import com.learnspring.hibernation.domain.Buyer;
import com.learnspring.hibernation.domain.Product;

public class App {
  
  public static void main(String[] args) {
    
    Administrator admin = new Administrator();
    
    Buyer tom = new Buyer("Tom");
    admin.create(tom);
    Buyer john = new Buyer("John");
    admin.save(john);
    Buyer mary = new Buyer("Mary");
    admin.save(mary);
    
    Product tea = new Product("Tea", 100.0);
    admin.create(tea);
    Product coffee = new Product("Coffee", 150.0);
    admin.save(coffee);
    Product orangeJuce = new Product("Orange juce", 120.0);
    admin.save(orangeJuce);
    Product redBull = new Product("Red Bull", 115.0);
    admin.save(redBull);
    Product cocaCola = new Product("Coca-Cola", 110.0);
    admin.save(cocaCola);
    Product iceCream = new Product("Ice cream", 50.0);
    admin.save(iceCream);
    Product cake = new Product("Cake", 70.0);
    admin.save(cake);
    Product milk = new Product("Milk", 40.0);
    admin.save(milk);
    Product water = new Product("Water", 10.0);
    admin.save(water);
    Product chocolate = new Product("Chocolate", 10.0);
    admin.save(chocolate);
    
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
    
    admin.displayOrderList(1L);
    admin.displayOrderList(2L);
    admin.displayOrderList(3L);
       
    admin.close();
    
  }
  
}
