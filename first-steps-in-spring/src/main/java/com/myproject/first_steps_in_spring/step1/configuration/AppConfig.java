package com.myproject.first_steps_in_spring.step1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.myproject.first_steps_in_spring.step1.juicer.*;

@Configuration
public class AppConfig {
  
  @Bean(name="grapefruit")
  public Juicy fruit() {
    return new Grapefruit();
  }
  
  @Bean(name="juicer")
  public Juicer juicer(Juicy fruit) {
    return new Juicer(fruit);
  }
  
}
