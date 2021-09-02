package com.revature.apispringbootimsapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.revature.apispringbootimsapp.model.ProductModel;

// Passing ProductModel and primary key data type
public interface ProductDAO extends JpaRepository<ProductModel, Integer> {
	
	// Custom query to return all tickets where user_id matches parameter
	@Query(value = "select p from product p where p.user_id = :id")
	public List<ProductModel> findByUserId(int id);
}
