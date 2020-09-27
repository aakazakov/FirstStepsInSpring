package com.learnspring.firstsimplerestapi.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.learnspring.firstsimplerestapi.dao.ProductDao;
import com.learnspring.firstsimplerestapi.domain.Product;

@Component
public class DataSourceManager implements CommandLineRunner {
  
  private ProductDao dao;
  
  public DataSourceManager(ProductDao dao) {
    this.dao = dao;
  }

  @Override
  public void run(String... args) throws Exception {
    
    dao.save(new Product("Black tea", "2021-12-31", 100.0));
    dao.save(new Product("Green tea", "2022-05-12", 150.5));
    dao.save(new Product("Coffee arabica", "2023-03-10", 200.0));
    dao.save(new Product("Coffee robusta", "2023-04-09", 180.99));
    dao.save(new Product("Red bull 0.3", "2024-08-06", 90.0));
    dao.save(new Product("Red bull 0.5", "2024-08-06", 110.10));
    dao.save(new Product("Ice cream vanilla", "2021-12-12", 50.0));
    dao.save(new Product("Ice cream chocolate", "2021-10-12", 50.0));
    dao.save(new Product("Ice cream raspberries", "2019-12-12", 50.0));
    dao.save(new Product("Chocolate dark", "2020-08-10", 120.0));
    dao.save(new Product("Chocolate milk", "2020-07-10", 100.0));
    dao.save(new Product("Water 0.5", "2021-01-01", 20.0));
    
  }

}
