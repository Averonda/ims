package com.revature.apispringbootimsapp.manager;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.apispringbootimsapp.dao.ProductDAO;
import com.revature.apispringbootimsapp.model.ProductModel;

import lombok.extern.java.Log;

@Service
@Transactional
@Log
public class ProductManagerImpl implements ProductManager {
	
	@Autowired
	private ProductDAO productDAO;
	
	// Find all products in db
	@Override
	//@Transactional(readOnly = true, propagation = Propagation.NEVER)
	public List<ProductModel> findAll() {
		//return StreamSupport.stream(dao.findAll().spliterator(), false).collect(Collectors.toList());
		return productDAO.findAll();
	}
	
	// Find single product with id of id
	@Override	
	public ProductModel findById(int id) {
		return null;		
	}
	
	@Override
	public ProductModel create(ProductModel user) {
		return null;
	}
	
	@Override
	public ProductModel delete(ProductModel user) {
		return null;
	}	

}
