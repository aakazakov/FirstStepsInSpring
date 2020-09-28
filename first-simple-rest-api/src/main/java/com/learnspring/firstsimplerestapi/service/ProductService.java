package com.learnspring.firstsimplerestapi.service;

import java.time.LocalDate;
import java.util.List;

import com.learnspring.firstsimplerestapi.domain.Product;

public interface ProductService {
  
  Product save(Product p);
  
  void removeById(Integer id);
  
  List<Product> findAll();
  
  Product findById(Integer id);
  
  List<Product> findByExpiredDateLessThanEqual(LocalDate expiredDate);
  
  List<Product> findByExpiredDateLessThanEqual(String expiredDate);
  
  List<Product> findByCostBetween(Double min, Double max);
  
}
