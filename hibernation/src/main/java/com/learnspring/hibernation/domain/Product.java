package com.learnspring.hibernation.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_tbl")
public class Product implements Domain {
  
  @Id
  @GeneratedValue
  @Column(name = "id_fld")
  private Long id;
  
  @Column(name = "name_fld")
  private String name;
  
  @Column(name = "price_fld")
  private Double price;
  
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
  
  public Product() { }
  
  public Product(String name, Double price) {
    this.name = name;
    this.price = price;
  }
   
}
