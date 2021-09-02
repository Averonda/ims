package com.revature.apispringbootimsapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.apispringbootimsapp.manager.ProductStockManager;
import com.revature.apispringbootimsapp.model.ProductStockModel;

@RestController
@RequestMapping(path = "/productstock")
public class ProductStockController {

	@Autowired
	private ProductStockManager manager;

	@GetMapping( path = "/all", produces = "application/json")
	public List<ProductStockModel> getAllProductStock(){
		return manager.findAll();
	}

}
