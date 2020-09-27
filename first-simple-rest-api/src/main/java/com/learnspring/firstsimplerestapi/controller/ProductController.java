package com.learnspring.firstsimplerestapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnspring.firstsimplerestapi.domain.Product;
import com.learnspring.firstsimplerestapi.service.ProductServiceImpl;

@RestController
@RequestMapping("/products")
public class ProductController {
  
  private ProductServiceImpl service;
  
  public ProductController(ProductServiceImpl service) {
    this.service = service;
  }
  
  @GetMapping
  public List<Product> getAllProducts() {
    return service.getAll();
  }
  
}
