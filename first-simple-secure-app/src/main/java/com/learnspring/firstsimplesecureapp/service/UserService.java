package com.learnspring.firstsimplesecureapp.service;

import java.util.List;

import com.learnspring.firstsimplesecureapp.domain.User;

public interface UserService {
  
  User save(User user);
  
  User getOne(Integer id);
  
  List<User> getAll();
  
  void delete(Integer id);
  
}
