package com.revature.apispringbootimsapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.revature.apispringbootimsapp.model.ProductStockModel;

public interface ProductStockDAO extends JpaRepository<ProductStockModel, Integer> {
	
	@Query(value = "select p from product_stock p where p.id = :id")
	public ProductStockModel findById(int id);

}
