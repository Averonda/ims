package com.revature.apispringbootimsapp.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.apispringbootimsapp.model.ProductStockModel;

public interface ProductStockDAO extends JpaRepository<ProductStockModel, Integer> {
	
	@Query(value = "select p from ProductStockModel p where p.id = :productId")
	public ProductStockModel findById(@Param("productId") int id);

	public List<ProductStockModel> findAll();
	
}
