
package com.revature.apispringbootimsapp.manager;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.apispringbootimsapp.dao.ProductDAO;
import com.revature.apispringbootimsapp.model.ProductModel;

import lombok.extern.java.Log;

@Log
@Service
@Transactional // all methods in this class will utilize the product manager and contextual sessions
public class ProductManagerImpl implements ProductManager {
	
	private static final Logger log = LoggerFactory.getLogger(ProductManagerImpl.class);
	
	@Autowired
	private ProductDAO dao;
	
	// Find all products in db
	@Override
	@Transactional(readOnly = true, propagation = Propagation.NEVER)
	public List<ProductModel> findAll() {
		log.info("findAll called");
		return StreamSupport.stream(dao.findAll().spliterator(), false).collect(Collectors.toList());
	}
	
	// Find all products from start index plus count
	@Override
	public List<ProductModel> findAll(int startIndex, int count) {
		Pageable pageable = PageRequest.of(startIndex, count);
		log.info("findAll starting with " + startIndex + "and count " + count);
		return StreamSupport.stream(dao.findAll(pageable).spliterator(), false).collect(Collectors.toList());	
	}
	
	// Find by user_id the total tickets submitted by them 
	@Override
	public List<ProductModel> findByUserId(int id) {
		return dao.findByUserId(Integer.valueOf(id));
	}
	
	// Find single product with id of id
	@Override	
	public ProductModel findById(int id) {
		return dao.findById(Integer.valueOf(id)).get();		
	}
	
	
	// Persists product in db
	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = {
			ConstraintViolationException.class }, propagation = Propagation.REQUIRES_NEW)
	public ProductModel create(ProductModel p) {
		log.debug(p.toString());
		return dao.save(p);
		
	}

}
