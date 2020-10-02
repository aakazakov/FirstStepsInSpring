package com.learnspring.firstsimplesecureapp.domain;

import javax.persistence.*;

@Entity
@Table(name = "product_test_tbl")
public class Product {
  
  @Id
  @GeneratedValue
  @Column(name = "id_fld")
  private Integer id;
  
  @Column(name = "title_fld")
  private String title;
  
  @Column(name = "cost_fld")
  private Double cost;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Double getCost() {
    return cost;
  }

  public void setCost(Double cost) {
    this.cost = cost;
  }

  public Product(String title, Double cost) {
    this.title = title;
    this.cost = cost;
  }

  public Product() { }
 
}
