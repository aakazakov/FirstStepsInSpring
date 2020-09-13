package com.learnspring.hibernation.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Buyer_tbl")
public class Buyer implements Domain {
  
  @Id
  @GeneratedValue
  @Column(name = "id_fld")
  private Long id;
   
  @Column(name = "name_fld")
  private String name;
  
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
  
}
