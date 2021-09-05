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

import com.revature.apispringbootimsapp.dao.ProductStockDAO;
import com.revature.apispringbootimsapp.model.ProductStockModel;

@Service
@Transactional
public class ProductStockManagerImpl implements ProductStockManager {

	@Autowired
	private ProductStockDAO dao;

	// finds all products in the database
	@Override
	@Transactional(readOnly = true, propagation = Propagation.NEVER)
	public List<ProductStockModel> findAll(String batchcode) {
		return this.dao.findAllByBatchcode("batch_code");
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.NEVER)
	public List<ProductStockModel> findAll() {
		return StreamSupport.stream(dao.findAll().spliterator(), false).collect(Collectors.toList());
	}

	// finds product by the product id number
	@Override
	public ProductStockModel findById(int id) {
		return dao.findById(Integer.valueOf(id)).get();
	}

//makes new product item
	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = {
			ConstraintViolationException.class }, propagation = Propagation.REQUIRES_NEW)
	public ProductStockModel create(ProductStockModel p) {
		return dao.save(p);
	}

	@Override
	public List<ProductStockModel> findAll(int quantity) {
		return dao.findAllByQuantityLessThan(Integer.valueOf(quantity));
	}

}
