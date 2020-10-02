package com.learnspring.firstsimplesecureapp.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.learnspring.firstsimplesecureapp.domain.Product;
import com.learnspring.firstsimplesecureapp.service.ProductService;

@Component
public class DataInitializer implements CommandLineRunner  {
  
  private ProductService service;
  
  public DataInitializer(ProductService service) {
    this.service = service;
  }

  @Override
  public void run(String... args) throws Exception {

    service.save(new Product("Product1", 100.0));
    service.save(new Product("Product2", 200.0));
    service.save(new Product("Product3", 300.0));
    service.save(new Product("Product4", 400.0));
    service.save(new Product("Product5", 500.0));
    service.save(new Product("Product6", 600.0));
    service.save(new Product("Product7", 700.0));
    service.save(new Product("Product8", 800.0));
    service.save(new Product("Product9", 900.0));
    
  }

}
