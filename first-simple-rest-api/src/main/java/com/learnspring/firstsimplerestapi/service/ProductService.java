package com.learnspring.firstsimplerestapi.service;

import java.time.LocalDate;
import java.util.List;

import com.learnspring.firstsimplerestapi.dto.ProductDto;

public interface ProductService {
  
  ProductDto save(ProductDto dto);
  
  void removeById(Integer id);
  
  List<ProductDto> findAll();
  
  ProductDto findById(Integer id);
  
  List<ProductDto> findByExpiredDateLessThanEqual(LocalDate expiredDate);
  
  List<ProductDto> findByExpiredDateLessThanEqual(String expiredDate);
  
  List<ProductDto> findByCostBetween(Double min, Double max);
  
}
