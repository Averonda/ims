package com.revature.apispringbootimsapp.manager;

import java.util.List;
import javax.transaction.Transactional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;

import com.revature.apispringbootimsapp.dao.ProductDAO;
import com.revature.apispringbootimsapp.model.ProductModel;

import lombok.extern.java.Log;

@Service
@Transactional
@Log
public class ProductManagerImpl implements ProductManager {
	
	@Autowired
	private ProductDAO dao;
	
	// Finds all products
	@Override
	public List<ProductModel> findAll() {
		return dao.findAll();
	}
	
	// Find single product with id of id
	@Override
	public ProductModel findById(int id) {
		return null;
	}
	
	// Add/create new product
	@Override
	public ProductModel create(ProductModel product) {
		return dao.save(product);
	}
	
	@Override
	public ProductModel delete(ProductModel user) {
		return null;
	}
	
	@Override
	public ProductModel findByTitle(String title) {
		return dao.findByTitle(title);
	}

}
