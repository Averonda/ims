package com.revature.apispringbootimsapp.manager;

import java.util.List;

import com.revature.apispringbootimsapp.model.ProductStockModel;

public interface ProductStockManager {

	List<ProductStockModel> findAll();

	List<ProductStockModel> findAll(String name);
	
	List<ProductStockModel> findAll(int count);

	ProductStockModel create(ProductStockModel psm);

	ProductStockModel findById(int id);

}
