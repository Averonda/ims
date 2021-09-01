package com.revature.apispringbootimsapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.apispringbootimsapp.model.ProductModel;

public interface ProductDAO extends JpaRepository<ProductModel, Integer> {

}
