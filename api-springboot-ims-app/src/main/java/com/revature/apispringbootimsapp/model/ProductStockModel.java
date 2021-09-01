package com.revature.apispringbootimsapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
@Entity(name="product_stock")
public class ProductStockModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
	@SequenceGenerator(name = "id_generator", sequenceName = "ticket_id_seq", allocationSize = 1)
	private int id;
	@Column
	private int product_id;
	@Column
	private Date transaction_date;
	@Column
	private String vendor;
	@Column
	private String batch_code;
	@Column
	private String invoice_number;
	@Column
	private int quantity;
	@Column
	private String transaction_type;


	public ProductStockModel(int product_id, Date transaction_date, String vendor, String batch_code,
			String invoice_number, int quantity, String transaction_type) {
		super();
		this.product_id = product_id;
		this.transaction_date = transaction_date;
		this.vendor = vendor;
		this.batch_code = batch_code;
		this.invoice_number = invoice_number;
		this.quantity = quantity;
		this.transaction_type = transaction_type;
	}
	
	
	
	
	
	
}
