package com.revature.apispringbootimsapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import javax.persistence.OneToMany;



@Entity
@Table(name = "product")
public class ProductModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
	@SequenceGenerator(name = "id_generator", sequenceName = "product_id_seq", allocationSize = 1)
	private int id;
	@Column
	private String title;
	@Column
	private String category;
	@Column 
	private String manufacturer;
	@Column (name = "minimum_limit")
	private int min;
	@Column
	private int boh;
	@OneToMany (mappedBy = "productId", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ProductStockModel> productStocks = new HashSet<>();
	 
	public void addProductStock(ProductStockModel productStockModel) {
		productStockModel.setProductId(this);
		productStocks.add(productStockModel);
	}

	public ProductModel(int id) {
		super();
		this.id = id;
	}

	public ProductModel() {
		super();
	}
	
	public ProductModel(String manufacturer) {
		super();
		this.manufacturer = manufacturer;
	}
	
	public ProductModel(int id, String title, String category, String manufacturer, int min, int boh,
			Set<ProductStockModel> productStocks) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.manufacturer = manufacturer;
		this.min = min;
		this.boh = boh;
		this.productStocks = productStocks;
	}

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


	public int getMin() {
		return min;
	}


	public void setMin(int min) {
		this.min = min;
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
				+ manufacturer + ", min=" + min + ", boh=" + boh + ", productStocks=" + productStocks + "]";
	}
	
}
