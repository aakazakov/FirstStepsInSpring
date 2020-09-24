package com.learnspring.firstspringbootapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learnspring.firstspringbootapp.domain.Product;
import com.learnspring.firstspringbootapp.repository.CacheStorageImpl;

@Service("cacheService")
public class CacheService {
  
  private CacheStorageImpl cache;
  private int edge;
  private int step;
  
  public CacheService(CacheStorageImpl cache) {
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
