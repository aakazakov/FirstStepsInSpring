package com.learnspring.firstsimplesecureapp.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.learnspring.firstsimplesecureapp.domain.User;

public interface UserService extends UserDetailsService {
  
  User save(User user);
  
  User getOne(Integer id);
  
  List<User> getAll();
  
  void delete(Integer id);
  
}
