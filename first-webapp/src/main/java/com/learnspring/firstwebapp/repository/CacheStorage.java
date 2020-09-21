package com.learnspring.firstwebapp.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.learnspring.firstwebapp.domain.Product;

@Repository
public class CacheStorage {

  private List<Product> cache;
  
  public void setCache(List<Product> cache) {
    this.cache = cache;
  }
  
  public List<Product> getCache() {
    return cache;
  }
  
  public CacheStorage() {
    cache = new ArrayList<>();
  }
  
  public void cleanCache() {
    if (cacheSize() > 0) cache.clear();
  }
  
  public Product add(Product p) {
    cache.add(p);
    return cache.get(cacheSize() - 1);
  }
  
  public void removeById(Long id) {
    for (Product p : cache) {
      if (p.getId() == id) {
        cache.remove(p);
        break;
      }
    }
  }
  
  public List<Product> getSomeOfTheCache(int start, int end) {
    return cache.subList(start, end);
  } 
  
  public int cacheSize() {
    return cache.size();
  }
  
}
