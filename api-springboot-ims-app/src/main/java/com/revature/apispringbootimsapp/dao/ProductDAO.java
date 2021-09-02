package com.revature.apispringbootimsapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.apispringbootimsapp.model.ProductModel;

// Passing ProductModel and primary key data-type
public interface ProductDAO extends JpaRepository<ProductModel, Integer> {
	
	public List<ProductModel> findAll();
	
}
