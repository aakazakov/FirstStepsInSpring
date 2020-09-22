package com.learnspring.firstwebapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnspring.firstwebapp.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
  
  List<Product> findAllByCostBetween(Double min, Double max);
  
}
