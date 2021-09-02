package com.revature.apispringbootimsapp.manager;

import java.util.List;

import com.revature.apispringbootimsapp.model.ProductModel;

public interface ProductManager {
	
	List<ProductModel> findAll();
	
	List<ProductModel> findAll(int startIndex, int count);
	
	List<ProductModel> findByUserId(int id);
	
	ProductModel findById(int id);
	
	ProductModel create(ProductModel p);

}
