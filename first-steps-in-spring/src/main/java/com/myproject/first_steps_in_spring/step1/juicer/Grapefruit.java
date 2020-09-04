package com.myproject.first_steps_in_spring.step1.juicer;

import org.springframework.stereotype.Component;

@Component("grapefruit")
public class Grapefruit implements Fruity {

  @Override
  public String getJuice() {
    return "grapefruit juice";
  }

}
