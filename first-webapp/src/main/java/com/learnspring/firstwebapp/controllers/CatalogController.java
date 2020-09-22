package com.learnspring.firstwebapp.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learnspring.firstwebapp.domain.Product;
import com.learnspring.firstwebapp.service.CacheService;
import com.learnspring.firstwebapp.service.ProductService;

@Controller
@RequestMapping("/catalog")
public class CatalogController {
  
  private final ProductService service;
  private final CacheService cacheService;
  
  public CatalogController(ProductService service, CacheService cacheService) {
    this.service = service;
    this.cacheService = cacheService;
  }
  
  @GetMapping
  public String catalog(Model model) {
    if (cacheService.cacheIsEmpty()) {
      cacheService.setCache(service.getAll());
    }
    List<Product> products = cacheService.getPart();
    
    if (products.isEmpty()) throw new RuntimeException("EMPTY CACHE");
    
    model.addAttribute("products", products);
    return "catalog";
  }
  
  @GetMapping(params = {"id", "action"})
  public String removeAction(Model model,
      @RequestParam(name = "id") Long id,
      @RequestParam(name = "action") String action) {
    if (action.equals("remove")) {
      service.remove(id);
    }
    return "redirect:/catalog/";
  }
  
  @PostMapping(params = {"action", "title", "cost"})
  public String addNewProductAction(
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
        throw new RuntimeException("the input value is not a number: " + cost); // Temporary solution...
      }
    }   
    return "redirect:/catalog/";
  }
  
  @PostMapping(params = {"action", "min", "max"})
  public String rangeAction(
      Model model,
      @RequestParam(name = "action") String action,
      @RequestParam(name = "min") String min,
      @RequestParam(name = "max") String max) {
    if (action.equals("range")) {
      try {
        Double minValue = Double.parseDouble(min.trim());
        Double maxValue = Double.parseDouble(max.trim());
        cacheService.setCache(service.getAllByCost(minValue, maxValue));
        List<Product> products = cacheService.getPart();
        model.addAttribute("products", products);
      } catch (NumberFormatException e) {
        throw new RuntimeException("the input value is not a number"); // Temporary solution...
      }
    }
    return "catalog";
  }
  
  @GetMapping(params = "param")
  public String more(Model model, @RequestParam(name = "param") String param) {
    if (param.equals("more")) {
      cacheService.expandDisplayedList();
    }
    return "redirect:/catalog/";
  }
  
}
