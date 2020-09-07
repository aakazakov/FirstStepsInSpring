package com.myproject.first_steps_in_spring.step1.juicer;

import org.springframework.stereotype.Component;

@Component("orange")
public class Orange implements Juicy {

  @Override
  public String getJuice() {
    return "orange juice";
  }
  
}
