package com.learnspring.firstwebapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learnspring.firstwebapp.domain.Product;
import com.learnspring.firstwebapp.repository.ProductRepository;

@Service
@Transactional
public class ProductService {
  
  @Autowired
  private ProductRepository repo;
  
  public Product getOne(Long id) {
    Optional<Product> p = repo.findById(id);
    if (!p.isPresent()) return null;
    return p.get();
  }
  
  public List<Product> getAll() {
    return repo.findAll();
  }
  
  public List<Product> getAllByCost(Double min, Double max) {
    return repo.findAllByCostBetween(max, min);
  }
  
  public Product save(Product p) {
    return repo.save(p);
  }
  
  public void remove(Long id) {
    repo.deleteById(id);
  } 
 
}
