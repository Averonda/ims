package com.revature.apispringbootimsapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

// Question: Why not include "implements Serializable" in class declaration?
// public class ProductModel implements Serializable { 
@Entity(name="product")
public class ProductModel {
	// Add ID
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
	@SequenceGenerator(name = "id_generator", sequenceName = "product_id_seq", allocationSize = 1)
	private int id;
	
	// Add Product Title
	@Column(name="title")
	private String title;
	
	// Add Product Category
	@Column(name="category")
	private String category;
	
	// Add Product Manufacturer
	@Column(name="manufacturer")
	private String manufacturer;
	
	// Add Minimum Limit
	@Column(name="minimum_limit")
	private int minimumLimit;
	
	// Add Balance-on-Hand
	@Column(name="boh")
	private int boh;

	// Generate default constructor
	public ProductModel() {
		super();
	}

	// Generate constructor (all fields)
	public ProductModel(int id, String title, String category, String manufacturer, int minimumLimit, int boh) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.manufacturer = manufacturer;
		this.minimumLimit = minimumLimit;
		this.boh = boh;
	}
	
	// Generate getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getMinimumLimit() {
		return minimumLimit;
	}

	public void setMinimumLimit(int minimumLimit) {
		this.minimumLimit = minimumLimit;
	}

	public int getBoh() {
		return boh;
	}

	public void setBoh(int boh) {
		this.boh = boh;
	}

	@Override
	public String toString() {
		return "ProductModel [id=" + id + ", title=" + title + ", category=" + category + ", manufacturer="
				+ manufacturer + ", minimumLimit=" + minimumLimit + ", boh=" + boh + "]";
	}	
	
	

	
}
