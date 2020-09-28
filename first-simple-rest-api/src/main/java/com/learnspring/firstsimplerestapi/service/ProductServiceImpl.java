package com.learnspring.firstsimplerestapi.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.learnspring.firstsimplerestapi.dao.ProductDao;
import com.learnspring.firstsimplerestapi.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {
  
  private ProductDao dao;
  
  public  ProductServiceImpl(ProductDao dao) {
    this.dao = dao;
  }

  @Override
  public List<Product> getAll() {
    return dao.findAll();
  }

  @Override
  public Product getById(Integer id) {
    return dao.findById(id).orElse(null);
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
    dao.deleteById(id);    
  }

  @Override
  public List<Product> findByExpiredDate(LocalDate expired) {
    return dao.findByExpiredDate(expired);
  }

}
