package com.learnspring.hibernation;

import javax.persistence.EntityManager;

import org.hibernate.cfg.Configuration;

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
  
  public <T> void create(T entity) {
    em.getTransaction().begin();
    em.persist(entity);
    em.getTransaction().commit();
  }
  
  public <T> T save(T entity) {
    em.getTransaction().begin();
    T domain = em.merge(entity);
    em.getTransaction().commit();
    return domain;
  }
  
  public <T> T read(Class<T> clazz, Long id) {
    em.getTransaction().begin();
    T domain = em.find(clazz, id);
    em.getTransaction().commit();
    return domain;  
  }
  
  public void close() {
    em.close();
  }
  
}
