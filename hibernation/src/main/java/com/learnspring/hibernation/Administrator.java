package com.learnspring.hibernation;

import javax.persistence.EntityManager;

import com.learnspring.hibernation.domain.Domain;

public class Administrator {
  
  private EntityManager em;
  
  public Administrator(EntityManager em) {
    this.em = em;
  }
  
  public void createEntity(Domain entity) {
    System.out.println("start creating");
    em.getTransaction().begin();
    em.persist(entity);
    em.getTransaction().commit();
    System.out.println("creation completed successfully");
  }
  
}
