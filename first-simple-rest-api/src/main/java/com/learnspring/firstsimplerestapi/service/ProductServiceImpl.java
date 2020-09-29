package com.learnspring.firstsimplerestapi.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.learnspring.firstsimplerestapi.dao.ProductDao;
import com.learnspring.firstsimplerestapi.domain.Product;
import com.learnspring.firstsimplerestapi.dto.ProductDto;
import com.learnspring.firstsimplerestapi.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {
  
  private final ProductDao dao;
  
  public  ProductServiceImpl(ProductDao dao) {
    this.dao = dao;
  }

  @Override
  public List<ProductDto> findAll() {
    return ProductMapper.MAPPER.fromProductList(dao.findAll());
  }

  @Override
  public ProductDto findById(Integer id) {
    return ProductMapper.MAPPER.fromProduct(dao.findById(id).orElse(null));
  }

  @Override
  public List<ProductDto> findByExpiredDateLessThanEqual(String expiredDate) {
    return ProductMapper.MAPPER
        .fromProductList(dao.findByExpiredDateLessThanEqual(LocalDate.parse(expiredDate)));
  }
  
  @Override
  public List<ProductDto> findByExpiredDateLessThanEqual(LocalDate expiredDate) {
    return ProductMapper.MAPPER
        .fromProductList(dao.findByExpiredDateLessThanEqual(expiredDate));
  }
  
  @Override
  public List<ProductDto> findByCostBetween(Double min, Double max) {
    return ProductMapper.MAPPER.fromProductList(dao.findByCostBetween(min, max));
  }

  @Override
  public ProductDto save(ProductDto dto) {
    Product p = ProductMapper.MAPPER.toProduct(dto);
    return ProductMapper.MAPPER.fromProduct(dao.save(p));
  }

  @Override
  public void removeById(Integer id) {
    dao.deleteById(id);
  }

}
