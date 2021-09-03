package com.revature.apispringbootimsapp.manager;

import java.util.List;

import javax.validation.Valid;

import com.revature.apispringbootimsapp.model.ProductStockModel;

public interface ProductStockManager {

	List<ProductStockModel> findAll();
	
	ProductStockModel findById(int id);
	
	ProductStockModel create(ProductStockModel p);

	ProductStockModel update(@Valid ProductStockModel p);
	
}
