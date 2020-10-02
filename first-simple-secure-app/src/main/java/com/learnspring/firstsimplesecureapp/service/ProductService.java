package com.learnspring.firstsimplesecureapp.service;

import java.util.List;

import com.learnspring.firstsimplesecureapp.domain.Product;

public interface ProductService {

  Product save(Product p);
  
  Product getOne(Integer id);
  
  List<Product> getAll();
  
  void delete(Integer id);
  
}
