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

import lombok.extern.java.Log;

import com.revature.apispringbootimsapp.dao.ProductStockDAO;
import com.revature.apispringbootimsapp.model.ProductStockModel;

@Log
@Service
@Transactional
public class ProductStockManagerImpl implements ProductStockManager {

	
	@Autowired
	private ProductStockDAO dao;
	
	@Override
	@Transactional(readOnly = true, propagation = Propagation.NEVER)
	public List<ProductStockModel> findAll() {
		return StreamSupport.stream(dao.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@Override
	public ProductStockModel findById(int id) {
		return dao.findById(Integer.valueOf(id)).get();
	}

	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = {
							   ConstraintViolationException.class }, propagation = Propagation.REQUIRES_NEW)  
	public ProductStockModel create(ProductStockModel p) {
		return dao.save(p);
	}

}
