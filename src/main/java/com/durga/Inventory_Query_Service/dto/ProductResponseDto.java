package com.durga.Inventory_Query_Service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Product inventory returned by the query endpoint.
 * The property spellings {@code avilableQuantity} and {@code avilable} are part
 * of the current JSON response contract.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {
	
	private String productCode;
	private String productName;
	/** Total quantity stored for the product, not the requested quantity. */
	private Integer avilableQuantity;
	/** Stored availability flag, not a comparison against the requested quantity. */
	private boolean avilable;

}
