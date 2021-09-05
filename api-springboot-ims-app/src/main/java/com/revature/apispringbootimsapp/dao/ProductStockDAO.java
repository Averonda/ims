package com.revature.apispringbootimsapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.apispringbootimsapp.model.ProductStockModel;

@Repository
public interface ProductStockDAO extends JpaRepository<ProductStockModel, Integer> {

	public List<ProductStockModel> findAllByBatchcode(String batch_code);

	public ProductStockModel findAllByQuantityLessThan(int quantity);

}
