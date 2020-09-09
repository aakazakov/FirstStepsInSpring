package com.learnspring.firstwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
  
  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("msg", "Hello, World");
    return "index";
  }
  
}
