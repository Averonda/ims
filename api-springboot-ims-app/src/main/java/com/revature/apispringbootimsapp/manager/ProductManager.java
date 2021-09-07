package com.revature.apispringbootimsapp.manager;

import java.util.List;

import com.revature.apispringbootimsapp.model.ProductModel;

public interface ProductManager {

	List<ProductModel> findAll();

//	List<ProductModel> findByUserId(int id);

	ProductModel findById(int id);

	ProductModel create(ProductModel p);

	ProductModel delete(ProductModel p);

	ProductModel findByTitle(String title);

	List<ProductModel> findAllByMinLessThanBoh();

	List<ProductModel> findAllByManufacturer(String manufacturer);
}
