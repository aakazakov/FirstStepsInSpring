package com.learnspring.firstsimplesecureapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnspring.firstsimplesecureapp.domain.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

}
