package com.revature.apispringbootimsapp.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product", schema = "ims")
@AllArgsConstructor
@Getter
@Setter
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
	@Column
	private int min;
	@Column
	private int boh;
	@OneToMany (mappedBy = "productId", fetch = FetchType.LAZY)
	private Set<ProductStockModel> productStocks;

	public ProductModel() {
		super();
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
		return "UserModel [id=" + id + ", title=" + title + ", category=" + category + ", manufacturer=" + manufacturer
				+ ", min=" + min + ", boh=" + boh + "]";
	}
}
