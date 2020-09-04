package com.myproject.first_steps_in_spring.step1.juicer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("juicer")
public class Juicer {
  
  private Fruity fruit;
  
  public Fruity getFruit() {
    return fruit;
  }

  @Autowired(required=false)
  @Qualifier("orange")
  public void setFruit(Fruity fruit) {
    this.fruit = fruit;
  }

  public Juicer() {
  }
  
  public Juicer(Fruity fruit) {
    this.fruit = fruit;
  }
  
  public String getJuice() {
    if (fruit == null) {
      return "There is no fruit in the juicer...";
    }
    return "Here is your " + fruit.getJuice();
  }
  
}
