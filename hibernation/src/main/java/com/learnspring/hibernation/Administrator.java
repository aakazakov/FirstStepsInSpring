package com.learnspring.hibernation;

import javax.persistence.EntityManager;

import org.hibernate.cfg.Configuration;

import com.learnspring.hibernation.domain.Domain;

public class Administrator {
  
  private EntityManager em;
  
  public Administrator() {
    init();
  }
  
  private void init() {
    em = new Configuration()
        .configure("hibernate.cfg.xml")
        .buildSessionFactory()
        .createEntityManager();
  }
  
  public void create(Domain entity) {
    em.getTransaction().begin();
    em.persist(entity);
    em.getTransaction().commit();
  }
  
  public void save(Domain entity) {
    em.getTransaction().begin();
    em.merge(entity);
    em.getTransaction().commit();
  }
  
  public void close() {
    em.close();
  }
  
}
