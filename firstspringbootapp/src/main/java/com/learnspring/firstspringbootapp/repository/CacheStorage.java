package com.learnspring.firstspringbootapp.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.learnspring.firstspringbootapp.domain.Product;


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
  
  public List<Product> getSomeOfTheCache(int edge) {
    int cacheSize = cacheSize();
    if (edge > cacheSize) edge = cacheSize;
    return cache.subList(cacheSize - edge, cacheSize);
  }
  
  public int cacheSize() {
    return cache.size();
  }
  
}
