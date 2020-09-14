package com.learnspring.hibernation.domain;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
public class Product implements Domain {
  
  @Id
  @GeneratedValue
  @Column(name = "ID")
  private Long id;
  
  @Column(name = "NAME")
  private String name;
  
  @Column(name = "PRICE")
  private Double price;
  
  @ManyToMany
  @JoinTable(
      name = "ORDERS",
      joinColumns = @JoinColumn(name = "PRODUCT_ID"),
      inverseJoinColumns = @JoinColumn(name = "BUYER_ID")
  )
  private List<Buyer> buyers;
   
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
  
  public Double getPrice() {
    return price;
  }
  
  public void setPrice(Double price) {
    this.price = price;
  }
  
  public List<Buyer> getBuyers() {
    return buyers;
  }
  
  public void setBuyers(List<Buyer> buyers) {
    this.buyers = buyers;
  }

  public Product() { }
  
  public Product(String name, Double price) {
    this.name = name;
    this.price = price;
  }
   
}
