package com.learnspring.firstwebapp.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learnspring.firstwebapp.entities.Product;
import com.learnspring.firstwebapp.service.ProductService;

@Controller
@RequestMapping("/catalog")
public class CatalogController {
  
  private final ProductService service;
  
  public CatalogController(ProductService service) {
    this.service = service;
  }
  
  @GetMapping
  public String catalog(Model model) {
    List<Product> products = service.getAll();
    model.addAttribute("products", products);
    return "catalog";
  }
  
  @PostMapping
  public String addNewProduct(Product product) {
    service.save(product);
    return "redirect:/catalog/";
  }
}
