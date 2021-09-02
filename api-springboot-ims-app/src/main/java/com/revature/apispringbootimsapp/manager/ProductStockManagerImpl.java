package com.revature.apispringbootimsapp.manager;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.apispringbootimsapp.dao.ProductStockDAO;
import com.revature.apispringbootimsapp.model.ProductStockModel;

import lombok.extern.java.Log;

@Service
@Transactional
@Log
public class ProductStockManagerImpl implements ProductStockManager {

	@Autowired
	private ProductStockDAO productStockDAO;

	@Override
	public List<ProductStockModel> findAll() {
		return productStockDAO.findAll();
	}


	@Override
	public ProductStockModel findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductStockModel create(ProductStockModel user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductStockModel delete(ProductStockModel user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductStockModel findByUserNameAndPassword(ProductStockModel user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductStockModel updatePassword(ProductStockModel user) {
		// TODO Auto-generated method stub
		return null;
	}

}
