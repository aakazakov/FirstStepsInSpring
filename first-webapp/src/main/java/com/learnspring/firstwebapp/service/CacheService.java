package com.learnspring.firstwebapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learnspring.firstwebapp.domain.Product;
import com.learnspring.firstwebapp.repository.CacheStorage;

@Service("cacheService")
public class CacheService {
  
  private CacheStorage cache;
  private int edge;
  private int step;
  
  public CacheService(CacheStorage cache) {
    this.cache = cache;
    this.edge = 0;
    this.step = 4;
  }

  public Product add(Product p) {
    return cache.add(p);
  }
  
  public void remove(Long id) {
    cache.removeById(id);
  }
  
  public List<Product> getAll() {
    return cache.getCache();
  }
  
  public List<Product> getPart() {
    increment();
    return cache.getSomeOfTheCache(0, edge);
  }
  
  private void increment() {
    edge += step;
    int cacheSize = cache.cacheSize();
    if (edge > cacheSize) edge = cacheSize;
  }
  
}
