package com.learnspring.hibernation.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {
  
  private Long id;
  private Long buyerId;
  private List<Product> productList;
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public Long getBuyerId() {
    return buyerId;
  }
  
  public void setBuyerId(Long buyerId) {
    this.buyerId = buyerId;
  }
  
  public List<Product> getProductList() {
    return productList;
  }
  
  public void setProductList(List<Product> productList) {
    this.productList = productList;
  }
  
  public Order() {
    productList = new ArrayList<>();
  }
  
}
