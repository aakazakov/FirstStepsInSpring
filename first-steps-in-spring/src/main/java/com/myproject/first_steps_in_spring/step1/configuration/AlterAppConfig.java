package com.myproject.first_steps_in_spring.step1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.myproject.first_steps_in_spring.step1.juicer.Juicer;

@Configuration
@ComponentScan("com.myproject.first_steps_in_spring.step1.juicer")
public class AlterAppConfig {

  @Bean(name="juicer")
  public Juicer juicer() {
    return new Juicer();
  }
  
}
