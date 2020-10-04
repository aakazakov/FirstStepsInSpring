package com.learnspring.firstsimplesecureapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learnspring.firstsimplesecureapp.domain.User;
import com.learnspring.firstsimplesecureapp.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

  private final UserService service;

  public UserController(UserService service) {
    this.service = service;
  }
  
  @GetMapping
  public String users(Model model) {
    List<User> users = service.getAll();
    model.addAttribute("users", users);
    return "users";
  }
  
}
