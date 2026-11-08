package com.durga.Inventory_Query_Service.service;

import com.durga.Inventory_Query_Service.dto.ProductResponseDto;
import com.durga.Inventory_Query_Service.entity.Product;

/**
 * Provides read-only product inventory queries.
 */
public interface ProductService {
	
	/**
	 * Looks up a product and returns its stored inventory values.
	 * The current implementation does not compare the requested quantity with stock.
	 *
	 * @param productCode code identifying the product
	 * @param requestQuantity requested quantity; currently unused
	 * @return product details, stored quantity, and stored availability
	 * @throws com.durga.Inventory_Query_Service.exception.ProductNotFoundException
	 *         if no product matches the code
	 */
	public ProductResponseDto checkStockAvilability(String productCode, Integer requestQuantity);
}
