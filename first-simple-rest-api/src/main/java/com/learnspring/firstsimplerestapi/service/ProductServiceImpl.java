package com.learnspring.firstsimplerestapi.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.learnspring.firstsimplerestapi.dao.ProductDao;
import com.learnspring.firstsimplerestapi.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {
  
  private final ProductDao dao;
  
  public  ProductServiceImpl(ProductDao dao) {
    this.dao = dao;
  }

  @Override
  public List<Product> findAll() {
    return dao.findAll();
  }

  @Override
  public Product findById(Integer id) {
    return dao.findById(id).orElse(null);
  }

  @Override
  public List<Product> findByExpiredDateLessThanEqual(String expiredDate) {
    return dao.findByExpiredDateLessThanEqual(LocalDate.parse(expiredDate));
  }
  
  @Override
  public List<Product> findByExpiredDateLessThanEqual(LocalDate expiredDate) {
    return dao.findByExpiredDateLessThanEqual(expiredDate);
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

}
