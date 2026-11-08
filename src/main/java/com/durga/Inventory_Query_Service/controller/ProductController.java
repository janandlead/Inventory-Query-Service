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

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;

	@GetMapping("/{productCode}")
	public ProductResponseDto checkStock(@Deprecated @PathVariable String productCode, @RequestParam Integer quantity) {

		return productService.checkStockAvilability(productCode, quantity);
	}
}
