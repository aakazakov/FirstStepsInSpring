package com.myproject.first_steps_in_spring.step1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.myproject.first_steps_in_spring.step1.juicer.*;

@Configuration
public class AppConfig {
  
  @Bean(name="grapefruit")
  public Fruity fruit() {
    return new Grapefruit();
  }
  
  @Bean(name="juicer")
  public Juicer juicer(Fruity fruit) {
    return new Juicer(fruit);
  }
  
}
