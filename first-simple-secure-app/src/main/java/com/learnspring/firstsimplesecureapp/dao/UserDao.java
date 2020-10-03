package com.learnspring.firstsimplesecureapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnspring.firstsimplesecureapp.domain.User;

public interface UserDao extends JpaRepository<User, Integer> {
  
  User findByLogin(String login);
  
}
