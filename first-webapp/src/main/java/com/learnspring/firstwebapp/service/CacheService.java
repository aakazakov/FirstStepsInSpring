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
    this.step = 4;
    this.edge = step;
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
    return cache.getSomeOfTheCache(edge);
  }
  
  public boolean cacheIsEmpty() {
    return cache.cacheSize() == 0;
  }
  
  public void setCache(List<Product> list) {
    cache.setCache(list);
  }
  
  public void cleanCache() {
    this.edge = step;
    cache.cleanCache();
  }
  
  public void expandDisplayedList() {
    edge += step;
  }
  
}
