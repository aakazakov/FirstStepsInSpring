package com.learnspring.hibernation;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.cfg.Configuration;

import com.learnspring.hibernation.domain.Buyer;
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
  
  public <T> int delete(Class<T> clazz, Long id) {
    em.getTransaction().begin();
    String query = "DELETE " +  clazz.getName() + " WHERE id = :id";
    int deleted = em.createQuery(query)
                    .setParameter("id", id)
                    .executeUpdate();
    em.getTransaction().commit();
    return deleted;
  } 
  
  public void displayOrderList(Long buyerId) {
    String query = "SELECT p.id, p.name, p.price FROM product p, buyer_product bp"
        + " WHERE bp.buyer_id = :id AND p.id = bp.product_id";
    @SuppressWarnings("unchecked")
    List<Product> list = em.createNativeQuery(query, Product.class)
                           .setParameter("id", buyerId)
                           .getResultList();
    int listSize = list.size();
    for (Product p : list) {
      System.out.println(p);
    }
    if (listSize == 0) System.out.println("The buyer id: " + buyerId + " has no purchases");
    System.out.println("Row count: " + listSize);
  }
  
  public void displayBuyerList(Long productId) {
    String query = "SELECT b.id, b.name FROM buyer b, buyer_product bp "
        + "WHERE b.id = bp.buyer_id AND bp.product_id = :id";
    @SuppressWarnings("unchecked")
    List<Buyer> list = em.createNativeQuery(query, Buyer.class)
                         .setParameter("id", productId)
                         .getResultList();
    int listSize = list.size();
    for (Buyer p : list) {
      System.out.println(p);
    }
    if (listSize == 0) System.out.println("No one bought the product id: " + productId);
    System.out.println("Row count: " + listSize);
  }
  
  public void close() {
    em.close();
  }
  
}
