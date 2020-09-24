package com.learnspring.firstspringbootapp.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.learnspring.firstspringbootapp.domain.Product;


@Repository
public class CacheStorageImpl implements CacheStorage<Product> {

  private List<Product> cache;
  
  @Override
  public void setCache(List<Product> cache) {
    this.cache = cache;
  }
  
  @Override
  public List<Product> getCache() {
    return cache;
  }
  
  public CacheStorageImpl() {
    cache = new ArrayList<>();
  }
  
  @Override
  public void cleanCache() {
    if (cacheSize() > 0) cache.clear();
  }
  
  @Override
  public Product add(Product p) {
    cache.add(p);
    return cache.get(cacheSize() - 1);
  }
  
  @Override
  public void removeById(Long id) {
    for (Product p : cache) {
      if (p.getId() == id) {
        cache.remove(p);
        break;
      }
    }
  }
  
  @Override
  public List<Product> getSomeOfTheCache(int edge) {
    int cacheSize = cacheSize();
    if (edge > cacheSize) edge = cacheSize;
    return cache.subList(cacheSize - edge, cacheSize);
  }
  
  @Override
  public int cacheSize() {
    return cache.size();
  }
  
}
