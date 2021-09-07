package com.revature.apispringbootimsapp.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name = "product_stock")
public class ProductStockModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator" )
	@SequenceGenerator(name = "id_generator", sequenceName = "product_stock_id_seq", allocationSize = 1)
	private int id;
	@ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id", nullable = false)
	private ProductModel productId;
	@Temporal(TemporalType.DATE)
	@Column(name = "transaction_date")
	private Date transactionDate = new Date();
	@Column
	private String vendor;
	@Column(name = "batch_code")
	private String batchCode;
	@Column (name = "invoice_number")
	private String invoiceNumber;
	@Column
	private int quantity;
	@Column(name = "transaction_type")
	private String transactionType;
	
	
	public ProductStockModel() {
		super();
	}


	public ProductStockModel(int id, ProductModel productId, Date transactionDate, String vendor, String batchCode,
			String invoiceNumber, int quantity, String transactionType) {
		super();
		this.id = id;
		this.productId = productId;
		this.transactionDate = transactionDate;
		this.vendor = vendor;
		this.batchCode = batchCode;
		this.invoiceNumber = invoiceNumber;
		this.quantity = quantity;
		this.transactionType = transactionType;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public ProductModel getProductId() {
		return productId;
	}


	public void setProductId(ProductModel productId) {
		this.productId = productId;
	}


	public Date getTransactionDate() {
		return transactionDate;
	}


	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}


	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}


	public String getBatchCode() {
		return batchCode;
	}


	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}


	public String getInvoiceNumber() {
		return invoiceNumber;
	}


	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getTransactionType() {
		return transactionType;
	}


	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	public ProductStockModel(int id, String vendor, String batchCode,String invoiceNumber,
			int quantity, String transactionType) {
		this.batchCode = batchCode;
		this.invoiceNumber = invoiceNumber;
		this.productId.setId(id);
		this.quantity = quantity;
		this.transactionType = transactionType;
		this.vendor = vendor;
	}


	@Override
	public String toString() {
		return "ProductStockModel [id=" + id + ", productId=" + productId + ", transactionDate=" + transactionDate
				+ ", vendor=" + vendor + ", batchCode=" + batchCode + ", invoiceNumber=" + invoiceNumber + ", quantity="
				+ quantity + ", transactionType=" + transactionType + "]";
	}
	
	
}
