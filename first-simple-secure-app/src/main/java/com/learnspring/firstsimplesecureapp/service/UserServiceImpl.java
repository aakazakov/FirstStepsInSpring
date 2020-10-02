package com.learnspring.firstsimplesecureapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learnspring.firstsimplesecureapp.dao.UserDao;
import com.learnspring.firstsimplesecureapp.domain.User;

@Service
public class UserServiceImpl implements UserService {
  
  private final UserDao dao;
  
  public UserServiceImpl(UserDao dao) {
    this.dao = dao;
  }

  @Override
  public User save(User user) {
    return dao.save(user);
  }

  @Override
  public User getOne(Integer id) {
    return dao.findById(id).orElse(null);
  }

  @Override
  public List<User> getAll() {
    return dao.findAll();
  }

  @Override
  public void delete(Integer id) {
    dao.deleteById(id);
  }

}
