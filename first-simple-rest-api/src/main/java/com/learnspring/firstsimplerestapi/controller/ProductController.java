package com.learnspring.firstsimplerestapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    return service.findAll();
  }
  
  @GetMapping("/{id}")
  public Product getOne(@PathVariable(name = "id") Integer id) {
    return service.findById(id);
  }
  
  @GetMapping(params = "exp")
  public List<Product> getByExpiredDate(@RequestParam(name = "exp") String expiredDate) {
    return service.findByExpiredDateLessThanEqual(expiredDate);
  }
  
  @GetMapping(params = {"min", "max"})
  public List<Product> getByCost(
      @RequestParam(name = "min") Double min,
      @RequestParam(name = "max") Double max) {
    return service.findByCostBetween(min, max);
  }
  
}
