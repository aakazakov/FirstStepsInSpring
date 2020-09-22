package com.learnspring.firstwebapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.learnspring.firstwebapp.service.CacheService;

@Controller
public class MainController {
  
  @Autowired
  private CacheService cacheService;
  
  @GetMapping("/")
  public String index(Model model) {
    cacheService.cleanCache();
    return "index";
  }
  
}
