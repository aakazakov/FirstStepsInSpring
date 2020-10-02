package com.learnspring.firstsimplesecureapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class MainController {
  
  @GetMapping("/")
  @ResponseBody
  public String greeting() {
    return "<h1 style=\"color:orange\">Hello, World ))</h1>"
        + "<a style=\"margin-left:2rem\" href=\"/app/catalog\">Goto Products</a>";
  }

}
