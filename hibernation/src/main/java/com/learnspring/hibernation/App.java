package com.learnspring.hibernation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.cfg.Configuration;

import com.learnspring.hibernation.domain.Buyer;

public class App {
  
  public static void main(String[] args) {

    EntityManagerFactory entityFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .buildSessionFactory();
    
    EntityManager em = entityFactory.createEntityManager();
    
    Administrator admin = new Administrator(em);
    
    Buyer buyer = new Buyer();
    buyer.setName("John");
    
    admin.createEntity(buyer);
    
    em.close();
    
  }
  
}
