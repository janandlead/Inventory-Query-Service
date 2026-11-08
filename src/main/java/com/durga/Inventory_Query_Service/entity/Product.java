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

/**
 * Inventory record stored in the {@code products} table.
 * Product name, code, and quantity are required. The availability flag is nullable
 * in persistence, but must be populated for mapping to a product response.
 */
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
	
	/** Stored availability flag, independent of the requested quantity. */
	private Boolean avialable;
	

}
