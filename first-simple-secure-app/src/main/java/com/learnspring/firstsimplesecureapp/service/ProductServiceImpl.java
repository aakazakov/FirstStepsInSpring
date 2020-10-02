package com.learnspring.firstsimplesecureapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learnspring.firstsimplesecureapp.dao.ProductDao;
import com.learnspring.firstsimplesecureapp.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {
  
  private final ProductDao dao;
  
  public ProductServiceImpl(ProductDao dao) {
    this.dao = dao;
  }

  @Override
  public Product save(Product p) {
    return dao.save(p);
  }

  @Override
  public Product getOne(Integer id) {
    return dao.findById(id).orElse(null);
  }

  @Override
  public List<Product> getAll() {
    return dao.findAll();
  }

  @Override
  public void delete(Integer id) {
    dao.deleteById(id);   
  }

}
