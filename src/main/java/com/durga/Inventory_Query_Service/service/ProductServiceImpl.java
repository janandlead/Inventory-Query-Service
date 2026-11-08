package com.durga.Inventory_Query_Service.service;

import org.springframework.stereotype.Service;

import com.durga.Inventory_Query_Service.dto.ProductResponseDto;
import com.durga.Inventory_Query_Service.entity.Product;
import com.durga.Inventory_Query_Service.exception.ProductNotFoundException;
import com.durga.Inventory_Query_Service.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	@Override
	public ProductResponseDto checkStockAvilability(String productCode, Integer requestQuantity) {
		// TODO Auto-generated method stub
		// Business realted check needs perform on service
		// All the exception handlings all needs to handle in the service

		Product product = productRepository.findByProductCode(productCode)
				.orElseThrow(() -> new ProductNotFoundException("Product not found: " + productCode));

		//Builder Pattern
		//mapstruct
		ProductResponseDto productResponseDto = new ProductResponseDto();

		productResponseDto.setProductCode(product.getProductCode());
		productResponseDto.setProductName(product.getProductName());
		productResponseDto.setAvilableQuantity(product.getQuantity());
		productResponseDto.setAvilable(product.getAvialable());

		return productResponseDto;
	}

}
