package com.durga.Inventory_Query_Service.service;

import com.durga.Inventory_Query_Service.dto.ProductResponseDto;
import com.durga.Inventory_Query_Service.entity.Product;

public interface ProductService {
	
	public ProductResponseDto checkStockAvilability(String productCode, Integer requestQuantity);
}
