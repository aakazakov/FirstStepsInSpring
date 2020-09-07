package com.myproject.first_steps_in_spring.step1.juicer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("juicer")
public class Juicer {
  
  private Juicy fruit;
  
  public Juicy getFruit() {
    return fruit;
  }

  @Autowired(required=false)
  @Qualifier("orange")
  public void setFruit(Juicy fruit) {
    this.fruit = fruit;
  }

  public Juicer() {
  }
  
  public Juicer(Juicy fruit) {
    this.fruit = fruit;
  }
  
  public String getJuice() {
    if (fruit == null) {
      return "There is no fruit in the juicer...";
    }
    return "Here is your " + fruit.getJuice();
  }
  
}
