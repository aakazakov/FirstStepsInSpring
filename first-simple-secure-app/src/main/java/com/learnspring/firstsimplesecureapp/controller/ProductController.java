package com.learnspring.firstsimplesecureapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learnspring.firstsimplesecureapp.domain.Product;
import com.learnspring.firstsimplesecureapp.service.ProductService;

@Controller
@RequestMapping("/catalog")
public class ProductController {
  
  private final ProductService service;

  public ProductController(ProductService service) {
    this.service = service;
  }

  @GetMapping
  public String catalog(Model model) {
    List<Product> products = service.getAll();
    model.addAttribute("products", products);
    return "catalog";
  }

}
