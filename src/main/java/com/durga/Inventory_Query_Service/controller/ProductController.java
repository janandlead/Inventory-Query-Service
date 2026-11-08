package com.durga.Inventory_Query_Service.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.durga.Inventory_Query_Service.dto.ProductResponseDto;
import com.durga.Inventory_Query_Service.service.ProductService;

import lombok.RequiredArgsConstructor;

/**
 * Exposes product inventory queries under {@code /api/products}.
 */
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;

	/**
	 * Returns stored inventory values for a product without modifying stock.
	 *
	 * @param productCode product code from the request path
	 * @param quantity required integer query parameter; currently unused by the service
	 * @return the product's stored quantity and availability flag
	 * @throws com.durga.Inventory_Query_Service.exception.ProductNotFoundException
	 *         if no product matches the code
	 */
	@GetMapping("/{productCode}")
	public ProductResponseDto checkStock(@Deprecated @PathVariable String productCode, @RequestParam Integer quantity) {

		return productService.checkStockAvilability(productCode, quantity);
	}
}
