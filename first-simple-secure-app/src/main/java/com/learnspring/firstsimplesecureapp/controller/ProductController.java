package com.learnspring.firstsimplesecureapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
  
  @GetMapping("/{id}")
  public String product(Model model, @PathVariable(name = "id") Integer id) {
    Product p = service.getOne(id);
    model.addAttribute("product", p);
    return "product";
  }
  
  @GetMapping(params = {"action", "id"})
  public String remove(
      Model model,
      @RequestParam(name = "action") String action,
      @RequestParam(name = "id") Integer id) {
    if (action.equals("remove")) {
      service.delete(id);
    }
    return "redirect:/catalog/";
  }
  
  @PostMapping(params = {"title", "cost"})
  public String addProduct(
      Model model,
      @RequestParam(name = "title") String title,
      @RequestParam(name = "cost") Double cost) {
    Product p = new Product(title, cost);
    service.save(p);
    return "redirect:/catalog/";
  }

}
