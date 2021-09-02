package com.revature.apispringbootimsapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.apispringbootimsapp.model.ProductStockModel;

public interface ProductStockDAO extends JpaRepository<ProductStockModel, Integer>{

	public List<ProductStockModel> findAll();
}
