package com.learnspring.firstsimplerestapi.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnspring.firstsimplerestapi.domain.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {
  
  List<Product> findByExpiredDate(LocalDate expiredDate);
  
  List<Product> findByCostBetween(Double min, Double max); 

}
