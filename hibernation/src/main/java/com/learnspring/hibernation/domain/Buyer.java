package com.learnspring.hibernation.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "BUYER")
public class Buyer {
  
  @Id
  @GeneratedValue
  @Column(name = "ID")
  private Long id;
   
  @Column(name = "NAME")
  private String name;
  
  @ManyToMany(cascade = CascadeType.REMOVE)
  @JoinTable(
      name = "BUYER_PRODUCT",
      joinColumns = @JoinColumn(name = "BUYER_ID"),
      inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID")
  )
  private List<Product> products;
    
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public List<Product> getProducts() {
    return products;
  }
  
  public void setProducts(List<Product> products) {
    this.products = products;
  }

  public Buyer() {
    products = new ArrayList<>();
  }
  
  public Buyer(String name) {
    this();
    this.name = name;
  }

  @Override
  public String toString() {
    return String.format("Class: %s, id: %d, name: %s", this.getClass().getSimpleName(), id, name);
  }
  
}
