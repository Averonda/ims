package com.revature.apispringbootimsapp.manager;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;

import org.springframework.transaction.annotation.Transactional;
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
		return dao.findById(Integer.valueOf(id)).get();
	}

	// Creates new products
	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = {
			ConstraintViolationException.class }, propagation = Propagation.REQUIRES_NEW)
	public ProductModel create(ProductModel product) {
		return dao.save(product);
	}

	@Override
	public ProductModel delete(ProductModel user) {
		return null;
	}

	// finds products by title
	@Override
	public ProductModel findByTitle(String title) {
		return dao.findByTitle(title);
	}

	// finds products by quantities less than min limit
	@Override
	public List<ProductModel> findAllByMinLessThanBoh() {
		return dao.findAllByMinLessThanBoh();
	}

    //finds products by manufacturer
	@Override
	public List<ProductModel> findAllByManufacturer(String manufacturer) {
		return dao.findAllByManufacturer(manufacturer);
	}

}
