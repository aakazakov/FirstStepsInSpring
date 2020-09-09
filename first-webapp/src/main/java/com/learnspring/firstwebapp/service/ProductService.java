package com.learnspring.firstwebapp.service;

import java.util.Comparator;
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
    List<Product> all = repo.getAll();
    all.sort(Comparator.comparingLong(Product::getId));
    return all;
  }
  
  public Product save(Product p) {
    return repo.save(p);
  }
  
  public void remove(Long id) {
    repo.remove(id);
  } 
 
}
