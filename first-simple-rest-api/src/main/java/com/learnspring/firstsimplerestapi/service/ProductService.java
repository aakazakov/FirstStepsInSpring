package com.learnspring.firstsimplerestapi.service;

import java.time.LocalDate;
import java.util.List;

import com.learnspring.firstsimplerestapi.domain.Product;

public interface ProductService {
  
  Product save(Product p);
  
  void removeById(Integer id);
  
  List<Product> getAll();
  
  Product getById(Integer id);
  
  List<Product> findByExpiredDate(LocalDate expired);
  
  List<Product> findByCostBetween(Double min, Double max);
  
}
