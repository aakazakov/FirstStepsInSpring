package com.learnspring.firstsimplerestapi.domain;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "product_tbl")
public class Product {
  
  @Id
  @GeneratedValue
  @Column(name = "id_fld")
  private Integer id;
  
  @Column(name = "title_fld")
  private String title;
  
  @Column(name = "expired_date_fld")
  private LocalDate expiredDate;
  
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

  public LocalDate getExpiredDate() {
    return expiredDate;
  }

  public void setExpiredDate(String expiredDate) {
    this.expiredDate = LocalDate.parse(expiredDate);
  }

  public Double getCost() {
    return cost;
  }

  public void setCost(Double cost) {
    this.cost = cost;
  }

  public Product(String title, String expiredDate, Double cost) {
    this.title = title;
    this.expiredDate = LocalDate.parse(expiredDate);
    this.cost = cost;
  }
  
  public Product() { }
  
}
