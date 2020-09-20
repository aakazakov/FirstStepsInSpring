package com.learnspring.firstwebapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learnspring.firstwebapp.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
  
  Iterable<Product> findAllByCostBetween(Double min, Double max);
  
}
