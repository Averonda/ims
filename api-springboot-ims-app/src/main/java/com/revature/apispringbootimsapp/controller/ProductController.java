package com.revature.apispringbootimsapp.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.apispringbootimsapp.manager.ProductManager;
import com.revature.apispringbootimsapp.model.ProductModel;

@CrossOrigin(origins = "http//localhost:4200")
@RestController
@RequestMapping(path = "/products")
public class ProductController {

	
	private static final Logger log = LoggerFactory.getLogger(ProductController.class);

	
	@Autowired
	private ProductManager manager;

	// Finds all entries in db
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/all", produces = "application/json")
	public List<ProductModel> getAllProducts() {
		log.info("ProductController.findAll called");
		return manager.findAll();
	}

	// Finds product by title
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/title", consumes = "application/json", produces = "application/json")
	public ProductModel findByTitle(String title) {
		log.info("ProductController.findByTitle called: "+title);		
		return manager.findByTitle(title);
	}

	// Finds all products under the 20 item limit working
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/productbalance", produces = "application/json")
	public List<ProductModel> findAllByMinLessThanBoh() {
		log.info("ProductController.findAllByMinLessThanBOH called");
		return manager.findAllByMinLessThanBoh();
	}

	// finds all products by the manufacturer
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/manufacturer", consumes = "application/json", produces = "application/json")
	public List<ProductModel> findAllByManufacturer(String manufacturer) {
		log.info("ProductController.findAllByManufacturer called");
		return manager.findAllByManufacturer(manufacturer);
	}

	// Finds products by user_id working
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/{id}", produces = "application/json")
	public ProductModel getProduct(@PathVariable int id) {
		log.info("ProductController.findByID called: " + id);
		return manager.findById(id);
	}

	// Updates product in database working
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "update/{id}", produces = "application/json")
	public ProductModel upDateProduct(@PathVariable int id, @Valid @RequestBody ProductModel product)
			throws ConfigDataResourceNotFoundException {
		ProductModel product1 = manager.findById(id);
		product1.setTitle(product.getTitle());
		product1.setCategory(product.getCategory());
		product1.setManufacturer(product.getManufacturer());
		product1.setMin(product.getMin());
		product1.setBoh(product.getBoh());
		final ProductModel upDatedProduct = manager.create(product1);
		log.info("ProductController.updateProduct called: "+product1.toString());
		return upDatedProduct;
	}

	// Creates a product using URL for user_id and entered information working
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
	public ProductModel create(@Valid @RequestBody ProductModel product) {
		log.info("ProductController.create called: "+product.toString());
		return manager.create(product);
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
