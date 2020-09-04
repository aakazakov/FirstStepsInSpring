package com.myproject.first_steps_in_spring.step1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myproject.first_steps_in_spring.step1.configuration.AppConfig;
import com.myproject.first_steps_in_spring.step1.configuration.AlterAppConfig;
import com.myproject.first_steps_in_spring.step1.juicer.Juicer;
import com.myproject.first_steps_in_spring.step1.juicer.Orange;

public class App {
  
  public static void main(String[] args) {  
    Juicer juicer;
    ApplicationContext context;
    
    // Vanilla
    juicer = new Juicer(new Orange());
    System.out.println(juicer.getJuice()); // Here is your orange juice
    
    // Spring (XML config)
    context = new ClassPathXmlApplicationContext("step1/config.xml");
    juicer = context.getBean("juicer", Juicer.class);
    System.out.println(juicer.getJuice()); // Here is your apple juice
    
    // Spring (JavaConfig)
    context = new AnnotationConfigApplicationContext(AppConfig.class);
    juicer = context.getBean("juicer", Juicer.class);
    System.out.println(juicer.getJuice()); // Here is your grapefruit juice
    
    // Spring (JavaConfig + @Autowired)
    context = new AnnotationConfigApplicationContext(AlterAppConfig.class);
    juicer = context.getBean("juicer", Juicer.class);
    System.out.println(juicer.getJuice()); // Here is your orange juice
  }
  
}