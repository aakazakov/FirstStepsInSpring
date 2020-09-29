package com.learnspring.firstsimplerestapi.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.learnspring.firstsimplerestapi.dto.EntityNotFoundResponse;
import com.learnspring.firstsimplerestapi.dto.ProductDto;
import com.learnspring.firstsimplerestapi.exception.EntityNotFoundException;
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
    checkId(id);
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
    checkId(id);
    dto.setId(id);
    return service.save(dto);
  }
  
  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable(name = "id") Integer id) {
    checkId(id);
    service.removeById(id);
  }
  
  private void checkId(@PathVariable Integer id) {
    if (!service.existsById(id)) {
      throw new EntityNotFoundException("non-existent", id);
    }
  }
  
  @ExceptionHandler
  public ResponseEntity<EntityNotFoundResponse> exceptionHandler(EntityNotFoundException e) {
    EntityNotFoundResponse response = new EntityNotFoundResponse();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    response.setStatus(HttpStatus.NOT_FOUND.value());
    response.setTimestamp(System.currentTimeMillis());
    response.setDateTime(dtf.format(LocalDateTime.now()));
    response.setMessage(e.getMessage());
    response.setEntityId(e.getId());
    response.setEntityTitle(e.getTitle());
    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }
  
}
