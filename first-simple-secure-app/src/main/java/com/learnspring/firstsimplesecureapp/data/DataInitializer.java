package com.learnspring.firstsimplesecureapp.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.learnspring.firstsimplesecureapp.domain.Product;
import com.learnspring.firstsimplesecureapp.domain.Role;
import com.learnspring.firstsimplesecureapp.domain.User;
import com.learnspring.firstsimplesecureapp.service.ProductService;
import com.learnspring.firstsimplesecureapp.service.UserService;

@Component
public class DataInitializer implements CommandLineRunner  {
  
  private ProductService productService;
  private UserService userService;
  
  public DataInitializer(ProductService productService, UserService userService) {
    this.productService = productService;
    this.userService = userService;    
  }

  @Override
  public void run(String... args) throws Exception {

    productService.save(new Product("Product1", 100.0));
    productService.save(new Product("Product2", 200.0));
    productService.save(new Product("Product3", 300.0));
    productService.save(new Product("Product4", 400.0));
    productService.save(new Product("Product5", 500.0));
    productService.save(new Product("Product6", 600.0));
    productService.save(new Product("Product7", 700.0));
    productService.save(new Product("Product8", 800.0));
    productService.save(new Product("Product9", 900.0));
    
    userService.save(new User("admin", "admin", Role.ADMIN));
    userService.save(new User("manager", "manager", Role.MANAGER));
    userService.save(new User("user1", "pass1", Role.USER));
    userService.save(new User("user2", "pass2", Role.USER));
    userService.save(new User("user3", "pass3", Role.USER));
    
  }

}
