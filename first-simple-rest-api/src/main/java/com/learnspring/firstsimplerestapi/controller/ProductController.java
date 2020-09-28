package com.learnspring.firstsimplerestapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnspring.firstsimplerestapi.domain.Product;
import com.learnspring.firstsimplerestapi.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
  
  private final ProductService service;
  
  public ProductController(ProductService service) {
    this.service = service;
  }
  
  @GetMapping
  public List<Product> getAll() {
    return service.getAll();
  }
  
  @GetMapping("/{id}")
  public Product getOne(@PathVariable(name = "id") Integer id) {
    return service.getById(id);
  }
  
}
