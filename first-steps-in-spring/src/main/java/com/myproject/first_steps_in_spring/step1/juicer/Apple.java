package com.myproject.first_steps_in_spring.step1.juicer;

import org.springframework.stereotype.Component;

@Component("apple")
public class Apple implements Juicy {

  @Override
  public String getJuice() {
    return "apple juice";
  }
  
}
