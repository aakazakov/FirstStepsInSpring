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
    
    admin.close();
    
  }
  
}
