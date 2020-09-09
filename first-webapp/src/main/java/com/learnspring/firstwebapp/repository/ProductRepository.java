package com.learnspring.firstwebapp.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.learnspring.firstwebapp.entities.Product;

@Repository
public class ProductRepository {
  
  private Map<Long, Product> repo;
  private Long index;
  
  public ProductRepository() {
    repo = new HashMap<>();
    index = 0L;
    fillRepo();
  }
  
  private void fillRepo() {
    repo.put(++index, new Product(index, "Product-1", 100.0));
    repo.put(++index, new Product(index, "Product-2", 200.0));
    repo.put(++index, new Product(index, "Product-3", 300.0));
    repo.put(++index, new Product(index, "Product-4", 400.0));
    repo.put(++index, new Product(index, "Product-5", 500.0));
  }
  
  public List<Product> getAll() {
    return new ArrayList<>(repo.values());
  }
  
  public Product getOne(Long id) {
    return repo.get(id);
  }
  
  public Product save(Product p) {
    if (p.getId() == null) {
      index++;
      p.setId(index);
    }
    repo.put(index, p);
    return p;
  }
  
  public boolean remove(Long id) {
    repo.remove(id);
    return repo.containsKey(id);
  }
  
}
