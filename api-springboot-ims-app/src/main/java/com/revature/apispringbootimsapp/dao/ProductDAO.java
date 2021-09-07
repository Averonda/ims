package com.revature.apispringbootimsapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.apispringbootimsapp.model.ProductModel;

// Passing ProductModel and primary key data-type
public interface ProductDAO extends JpaRepository<ProductModel, Integer> {
	
	public List<ProductModel> findAll();
	
	public ProductModel findById(int id);

	@Query(value = "select p from ProductModel p where p.title = :title")
	public ProductModel findByTitle(@Param("title") String title);

}
