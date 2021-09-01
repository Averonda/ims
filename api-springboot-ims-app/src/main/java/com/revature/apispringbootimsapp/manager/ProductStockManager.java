package com.revature.apispringbootimsapp.manager;

import java.util.List;

import com.revature.apispringbootimsapp.model.ProductStockModel;

public interface ProductStockManager {

	List<ProductStockModel> findAll();
	
	List<ProductStockModel> findAll(int startIndex, int count);
	
	List<ProductStockModel> findById(int id);
	
	ProductStockModel create(ProductStockModel p);
	
}
