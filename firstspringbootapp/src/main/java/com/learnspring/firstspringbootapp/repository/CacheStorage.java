package com.learnspring.firstspringbootapp.repository;

import java.util.List;

public interface  CacheStorage<T> {
  
  public void setCache(List<T> cache);
  
  public List<T> getCache();
  
  public void cleanCache();
  
  public T add(T entity);
  
  public void removeById(Long id);
  
  public List<T> getSomeOfTheCache(int edge);
  
  public int cacheSize();
  
}
