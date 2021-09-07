package com.revature.apispringbootimsapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	// Finds all entries
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
	
	
	
	
//    @PostMapping("/add")
//    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
//        Employee newEmployee = employeeService.addEmployee(employee);
//        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
//    }
	
//	// Finds products by user_id
//	@GetMapping(path = "/{id}", produces = "application/json")
//	public List<ProductModel> getProduct(@PathVariable int id) {
//		return manager.findByUserId(id);
//	}
//	
//	// Updates product in db (note to self: @PostMapping or @PutMapping)
//	@PostMapping(path = "update/{id}", produces = "application/json")
//	public ProductModel upDateProductModel(@PathVariable int id,@Valid @RequestBody ProductModel product) throws ConfigDataResourceNotFoundException {
//		ProductModel product1 = manager.findById(id);
//		product1.setTitle(product.getTitle());
//		product1.setCategory(product.getCategory());
//		product1.setManufacturer(product.getManufacturer());
//		product1.setMinimumLimit(product.getMinimumLimit());
//		product1.setBoh(product.getBoh());
//		final ProductModel upDatedProductModel = manager.create(product1);
//		return upDatedProductModel;		
//	}
//	
//	// Creates a product using URL for user_id and entered information
//	@PostMapping(path = "/create/{id}", consumes = "application/json", produces = "application/json")
//	public ProductModel create(@Valid @RequestBody ProductModel product) {
//		return manager.create(product);
//	}
//	
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
//		Map<String, String> errors = new HashMap<>();
//		ex.getBindingResult().getAllErrors().forEach((error) -> {
//			String fieldName = ((FieldError) error).getField();
//			String errorMessage = error.getDefaultMessage();
//			errors.put(fieldName, errorMessage);
//		});
//		for(Map.Entry<String, String> error : errors.entrySet()) {
//			log.info(error.getKey() + " " + error.getValue());
//		}
//		return errors;
//	}
//
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(ConstraintViolationException.class)
//	public Map<String, String> handleConstraintViolationExceptions(ConstraintViolationException ex) {
//		Map<String, String> errors = new HashMap<>();
//		errors.put("message", ex.getCause().getLocalizedMessage());
//		for(Map.Entry<String, String> error : errors.entrySet()) {
//			log.info(error.getKey() + " " + error.getValue());
//		}
//		return errors;
//	}	

}
