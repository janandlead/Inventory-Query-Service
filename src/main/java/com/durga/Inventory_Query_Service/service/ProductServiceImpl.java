package com.durga.Inventory_Query_Service.service;

import org.springframework.stereotype.Service;

import com.durga.Inventory_Query_Service.dto.ProductResponseDto;
import com.durga.Inventory_Query_Service.entity.Product;
import com.durga.Inventory_Query_Service.exception.ProductNotFoundException;
import com.durga.Inventory_Query_Service.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

/**
 * Retrieves inventory through {@link ProductRepository} and maps it to response DTOs.
 * Availability is copied from the stored flag rather than calculated from quantity.
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	/**
	 * {@inheritDoc}
	 *
	 * @throws NullPointerException if the stored availability flag is null and cannot
	 *         be unboxed into the response's primitive boolean
	 */
	@Override
	public ProductResponseDto checkStockAvilability(String productCode, Integer requestQuantity) {

		Product product = productRepository.findByProductCode(productCode)
				.orElseThrow(() -> new ProductNotFoundException("Product not found: " + productCode));

		ProductResponseDto productResponseDto = new ProductResponseDto();

		productResponseDto.setProductCode(product.getProductCode());
		productResponseDto.setProductName(product.getProductName());
		productResponseDto.setAvilableQuantity(product.getQuantity());
		productResponseDto.setAvilable(product.getAvialable());

		return productResponseDto;
	}

}
