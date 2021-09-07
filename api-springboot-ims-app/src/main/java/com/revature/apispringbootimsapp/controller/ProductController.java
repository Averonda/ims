package com.revature.apispringbootimsapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.apispringbootimsapp.manager.ProductManager;
import com.revature.apispringbootimsapp.model.ProductModel;

@CrossOrigin(origins = "http//localhost:4200")
@RestController
@RequestMapping(path = "/products")
public class ProductController {
	
	@Autowired
	private ProductManager manager;
	
	@GetMapping(path = "/{id}", produces = "application/json")
	public ProductModel temp(@PathVariable int id) {
		return manager.tmp(id);
	}
	
	
	// Finds all entries in db
	@GetMapping(path = "/all", produces = "application/json")
	public List<ProductModel> getAllProducts() {
		return manager.findAll();
	}
	
	// Add new product
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
	public ProductModel add(@Valid @RequestBody ProductModel product) {
		return manager.create(product);
	}
	
	@GetMapping(path ="/title", consumes = "application/json", produces = "application/json")
	public ProductModel findByTitle(String title) {
		return manager.findByTitle(title);
	}

}
