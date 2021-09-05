package com.revature.apispringbootimsapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.apispringbootimsapp.manager.ProductStockManager;
import com.revature.apispringbootimsapp.manager.ProductStockManagerImpl;
import com.revature.apispringbootimsapp.model.ProductStockModel;

@RestController
@RequestMapping(path = "/products")
public class ProductStockController {

	@Autowired
	private ProductStockManager manager;

	@GetMapping(produces = "application/json")
	public List<ProductStockModel> getAllProducts() {
		return manager.findAll();
	}

	@GetMapping(path="/batch/{batch_code}", produces="application/json")
	public List<ProductStockModel> byBatchcode(@PathVariable String batch_code) {
		System.out.println(batch_code);
		return manager.findAll(batch_code);
	}

	@GetMapping(path="/quantity/{quantity}", produces="application/json")
	public List<ProductStockModel> byQuantity(@PathVariable int quantity) {
		System.out.println(quantity);
		return manager.findAll(quantity);
	}

	@GetMapping(path = "/{id}", produces = "application/json")
	public ProductStockModel getPsm(@PathVariable int id) {
		return manager.findById(id);
	}

//	Creates a ticket using URL for user_id and entered information
	@PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
	public ProductStockModel create(@Valid @RequestBody ProductStockModel psm) {
		return manager.create(psm);
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
