package com.learnspring.firstwebapp.entities;

import java.util.Objects;

public class Product {

  private long id;
  private String title;
  private double cost;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public double getCost() {
    return cost;
  }

  public void setCost(double cost) {
    this.cost = cost;
  }

  public Product() {
    this.id = 0L;
    this.title = null;
    this.cost = 0.0;
  }

  public Product(long id, String title, double cost) {
    this.id = id;
    this.title = title;
    this.cost = cost;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, cost);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || obj.getClass() != this.getClass()) return false;
    Product p = (Product) obj;
    return p.id == id && Objects.equals(p.title, title) && p.cost == cost;
  }

  @Override
  public String toString() {
    return String.format("ID: %d, title: %s, cost: %f", id, title, cost);
  }
  
}
