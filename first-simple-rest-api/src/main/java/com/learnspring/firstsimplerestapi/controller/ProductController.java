package com.learnspring.firstsimplerestapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.learnspring.firstsimplerestapi.dto.ProductDto;
import com.learnspring.firstsimplerestapi.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
  
  private final ProductService service;
  
  public ProductController(ProductService service) {
    this.service = service;
  }
  
  @PostMapping
  public ProductDto add(@RequestBody ProductDto dto) {
    return service.save(dto);
  }
  
  @GetMapping
  public List<ProductDto> getAll() {
    return service.findAll();
  }
  
  @GetMapping("/{id}")
  public ProductDto getOne(@PathVariable(name = "id") Integer id) {
    return service.findById(id);
  }
  
  @GetMapping(params = "exp")
  public List<ProductDto> getByExpiredDate(@RequestParam(name = "exp") String expiredDate) {
    return service.findByExpiredDateLessThanEqual(expiredDate);
  }
  
  @GetMapping(params = {"min", "max"})
  public List<ProductDto> getByCost(
      @RequestParam(name = "min") Double min,
      @RequestParam(name = "max") Double max) {
    return service.findByCostBetween(min, max);
  }
  
  @PutMapping("/{id}")
  public ProductDto update(@PathVariable(name = "id") Integer id, @RequestBody ProductDto dto) {
    dto.setId(id);
    return service.save(dto);
  }
  
  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable(name = "id") Integer id) {
    service.removeById(id);
  }
  
}
