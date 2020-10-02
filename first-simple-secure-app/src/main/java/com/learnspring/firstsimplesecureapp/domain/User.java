package com.learnspring.firstsimplesecureapp.domain;

import javax.persistence.*;

@Entity
@Table(name = "user_test_tbl")
public class User {
  
  @Id
  @GeneratedValue
  @Column(name = "id_fld")
  private Integer id;
  
  @Column(name = "login_fld")
  private String login;
  
  @Column(name = "password_fld")
  private String password;
  
  @Column(name = "role_fld")
  @Enumerated(EnumType.STRING)
  private Role role;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public User(String login, String password, Role role) {
    this.login = login;
    this.password = password;
    this.role = role;
  }
  
  public User() { }
  
}
