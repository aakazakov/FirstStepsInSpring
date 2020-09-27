package com.learnspring.firstsimplerestapi.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.learnspring.firstsimplerestapi.domain.Product;

public class ProductServiceImpl implements ProductService {
  
  @Autowired
  private ProductService dao;

  @Override
  public List<Product> getAll() {
    return dao.getAll();
  }

  @Override
  public Product getById(Integer id) {
    return dao.getById(id);
  }

  public List<Product> findByExpiredDate(String expired) {
    return dao.findByExpiredDate(LocalDate.parse(expired));
  }

  @Override
  public List<Product> findByCostBetween(Double min, Double max) {
    return dao.findByCostBetween(min, max);
  }

  @Override
  public Product save(Product p) {
    return dao.save(p);
  }

  @Override
  public void removeById(Integer id) {
    dao.removeById(id);    
  }

  @Override
  public List<Product> findByExpiredDate(LocalDate expired) {
    return dao.findByExpiredDate(expired);
  }

}
