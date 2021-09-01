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

	private static final Logger log = LoggerFactory.getLogger(ProductStockManagerImpl.class);
	
	@Autowired
	private ProductStockDAO dao;
	
	@Override
	public List<ProductStockModel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductStockModel> findAll(int startIndex, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductStockModel> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductStockModel create(ProductStockModel p) {
		// TODO Auto-generated method stub
		return null;
	}

}
