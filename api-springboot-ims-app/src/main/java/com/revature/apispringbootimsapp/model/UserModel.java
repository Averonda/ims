package com.revature.apispringbootimsapp.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.revature.apispringbootimsapp.ApiSpringbootImsAppApplication;

import lombok.Getter;


@Entity
@Table(name = user)
public class UserModel {

	
	private int id;
	private String title;
	private String category;
	private String manufacturer;
	private int min;
	private int boh;
	
	
	
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
		return "UserModel [id=" + id + ", title=" + title + ", category=" + category + ", manufacturer=" + manufacturer
				+ ", min=" + min + ", boh=" + boh + "]";
	}
}