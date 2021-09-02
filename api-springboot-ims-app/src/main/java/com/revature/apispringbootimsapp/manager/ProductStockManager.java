package com.revature.apispringbootimsapp.manager;

import java.util.List;

import com.revature.apispringbootimsapp.model.ProductStockModel;

public interface ProductStockManager {

	List<ProductStockModel> findAll();
	
	ProductStockModel findById(int id);

	ProductStockModel create(ProductStockModel user);

	ProductStockModel delete(ProductStockModel user);

	ProductStockModel findByUserNameAndPassword(ProductStockModel user);

	// Added by AP to update password (Interface - UserManager)
	ProductStockModel updatePassword(ProductStockModel user);
}
