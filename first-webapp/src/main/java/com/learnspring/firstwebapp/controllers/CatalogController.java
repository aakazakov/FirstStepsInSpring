package com.learnspring.firstwebapp.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learnspring.firstwebapp.domain.Product;
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
  
  @GetMapping(params = {"id", "action"})
  public String action(Model model,
      @RequestParam(name = "id") Long id,
      @RequestParam(name = "action") String action) {
    if (action.equals("remove")) {
      service.remove(id);
    }
    return "redirect:/catalog/";
  }
  
  @PostMapping(params = {"action", "title", "cost"})
  public String addNewProduct(
      @RequestParam(name = "action") String action,
      @RequestParam(name = "title") String title,
      @RequestParam(name = "cost") String cost) {
    if (action.equals("add")) {
      try {
        Double costValue = Double.parseDouble(cost.trim());
        Product p = new Product();
        p.setTitle(title);
        p.setCost(costValue);
        service.save(p);
      } catch (NumberFormatException e) {
        throw new RuntimeException("the input value is not a number: " + cost);
      }
    }   
    return "redirect:/catalog/";
  }
  
}
