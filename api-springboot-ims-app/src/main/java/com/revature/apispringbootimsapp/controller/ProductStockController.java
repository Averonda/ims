package com.revature.apispringbootimsapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.apispringbootimsapp.manager.ProductManager;
import com.revature.apispringbootimsapp.manager.ProductStockManager;
import com.revature.apispringbootimsapp.model.ProductModel;
import com.revature.apispringbootimsapp.model.ProductStockModel;

import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping(path = "/productstock")
public class ProductStockController {

	
	@Autowired
	private ProductStockManager productStockManager;
	
	@Autowired
	private ProductManager productManager;
	
	
	// Returns all invoices
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="/invoices", produces = "application/json", consumes = "application/json")
	public List<ProductStockModel> getAllInvoices(){
		return productStockManager.findAll();
	}
	
	// Persists new invoice(ProductStockModel) to database and updates BOH for parent ProductModel
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
	public ProductStockModel create(@Valid @RequestBody ProductStockModel p) {
		ProductModel productModel = new ProductModel();
		productModel = productManager.findById(p.getProductId().getId());
		if(productModel == null) {
			productModel = productManager.create(p.getProductId());
			p.setProductId(productModel);
		}

		if(p.getTransactionType().equals("OUT")) {
			int newQuantity = (-1 * p.getQuantity());
			p.setQuantity(newQuantity);
		}
		int newBoh = productModel.getBoh() + p.getQuantity();
		productModel.setBoh(newBoh);
		
		p.setProductId(productModel);
		return productStockManager.create(p);
		
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ConstraintViolationException.class)
	public Map<String, String> handleConstraintViolationExceptions(ConstraintViolationException ex) {
		Map<String, String> errors = new HashMap<>();
		errors.put("message", ex.getCause().getLocalizedMessage());
		return errors;
	}
	
	
	
	
}
