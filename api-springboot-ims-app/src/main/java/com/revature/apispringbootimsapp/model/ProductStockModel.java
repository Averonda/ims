package com.revature.apispringbootimsapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "product_stock")
public class ProductStockModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
	@SequenceGenerator(name = "id_generator", sequenceName = "product_stock_id_seq", allocationSize = 1)
	private int id;
	@Column(name = "product_id")
	private int product_id;
	@Column(name = "transaction_date")
	private Date transaction_date;
	@Column(name = "vendor")
	private String vendor;
	@Column(name = "batch_code")
	private String batchcode;
	@Column(name = "invoice_number")
	private String invoice_number;
	@Column(name = "quantity")
	public int quantity;
	@Column(name = "transaction_type")
	private String transaction_type;

	public ProductStockModel(int product_id, Date transaction_date, String vendor, String batch_code,
			String invoice_number, int quantity, String transaction_type) {
		super();
		this.product_id = product_id;
		this.transaction_date = transaction_date;
		this.vendor = vendor;
		this.batchcode = batch_code;
		this.invoice_number = invoice_number;
		this.quantity = quantity;
		this.transaction_type = transaction_type;
	}

	public ProductStockModel(String batch_code, int quantity) {
		super();
		this.batchcode = batch_code;
		this.quantity = quantity;
	}

	public ProductStockModel(String vendor) {
		super();
		this.vendor = vendor;
	}

	public ProductStockModel() {
		super();

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public Date getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getBatch_code() {
		return batchcode;
	}

	public void setBatch_code(String batch_code) {
		this.batchcode = batch_code;
	}

	public String getInvoice_number() {
		return invoice_number;
	}

	public void setInvoice_number(String invoice_number) {
		this.invoice_number = invoice_number;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}

}
