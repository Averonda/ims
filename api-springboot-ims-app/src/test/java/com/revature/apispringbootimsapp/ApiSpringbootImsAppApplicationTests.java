package com.revature.apispringbootimsapp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.apispringbootimsapp.controller.ProductController;
import com.revature.apispringbootimsapp.controller.ProductStockController;
import com.revature.apispringbootimsapp.dao.ProductDAO;
import com.revature.apispringbootimsapp.dao.ProductStockDAO;
import com.revature.apispringbootimsapp.model.ProductModel;
import com.revature.apispringbootimsapp.model.ProductStockModel;

@SpringBootTest
class ApiSpringbootImsAppApplicationTests {

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private ProductStockDAO productStockDAO;

	@Autowired
	private ProductStockController productStockController;
	
	@Autowired
	private ProductController productController;

	@Test
	public void returnAllProduct_Test() {
		List<ProductModel> productList = productDAO.findAll();
		assertThat(productList).isNot(null);
	}

	@Test
	public void returnAllProductStock_Test() {
		List<ProductStockModel> productStockList = productStockDAO.findAll();
		assertThat(productStockList).isNot(null);
	}

	@Test
	public void persistProductStockandUpdateBOH() {
		ProductModel pm = new ProductModel(1);
		ProductStockModel psm = new ProductStockModel(1, pm, new Date(), "Nintendo", "4864153484", "4fd86as48", 10,
				"IN");
		ProductStockModel psm2 = psm;

		psm = productStockController.create(psm);

		assertThat(psm).isNotEqualTo(psm2);
	}

}
