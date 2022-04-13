package com.springrest.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.springrest.entities.Product;

public interface ProductDao extends JpaRepository<Product, Long>{

}
