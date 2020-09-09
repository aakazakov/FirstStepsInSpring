package com.learnspring.firstwebapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learnspring.firstwebapp.entities.Product;
import com.learnspring.firstwebapp.repository.ProductRepository;

@Service
public class ProductService {
  
  private ProductRepository repo;
  
  public ProductService(ProductRepository repo) {
    this.repo = repo;
  }
  
  public Product getOne(Long id) {
    return repo.getOne(id);
  }
  
  public List<Product> getAll() {
    return repo.getAll();
  }
  
  public Product save(Product p) {
    return repo.save(p);
  }
  
  public void remove(Long id) {
    repo.remove(id);
  } 
 
}
