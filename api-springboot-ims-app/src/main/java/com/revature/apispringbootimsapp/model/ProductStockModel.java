package com.revature.apispringbootimsapp.model;


import java.util.Date;

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


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table( name = "product_stock", schema = "ims")
public class ProductStockModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator" )
	@SequenceGenerator(name = "id_generator", sequenceName = "product_stock_id_seq", allocationSize = 1)
	private int id;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "product_stock_fk", nullable = false)
	private ProductModel productId;
	@Temporal(TemporalType.DATE)
	@Column(name = "transaction_date")
	private Date transactionDate;
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
	
}
