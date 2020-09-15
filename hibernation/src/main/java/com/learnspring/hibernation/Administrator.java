package com.learnspring.hibernation;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.cfg.Configuration;

import com.learnspring.hibernation.domain.Product;

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
  
  public void displayOrderList(Long buyerId) {
    String query = String.format(
        "SELECT * FROM product p, buyer_product bp"
        + " WHERE bp.buyer_id = %d AND p.id = bp.product_id",
        buyerId
    );
    @SuppressWarnings("unchecked")
    List<Product> list = em.createNativeQuery(query, Product.class).getResultList();
    for (Product p : list) {
      System.out.println(p);
    }
    System.out.println("Row count: " + list.size());
  }
  
  public void close() {
    em.close();
  }
  
}
