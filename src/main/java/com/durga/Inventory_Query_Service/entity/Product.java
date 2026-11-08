package com.durga.Inventory_Query_Service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="products")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Product {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="product_name", nullable = false)
	private String productName;
	
	@Column(name="product_code", nullable = false)
	private String productCode;
	
	@Column(nullable = false)
	private Integer quantity;
	
	private Boolean avialable;
	

}
