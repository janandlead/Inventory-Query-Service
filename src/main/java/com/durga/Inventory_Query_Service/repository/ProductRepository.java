package com.durga.Inventory_Query_Service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.durga.Inventory_Query_Service.entity.Product;

/**
 * Provides persistence operations and product-code lookup for inventory records.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	
	/**
	 * Finds the single product matching a code.
	 * Product codes should be unique; the entity does not enforce that constraint.
	 *
	 * @param productCode product code to match
	 * @return the matching product, or an empty optional when none exists
	 * @throws org.springframework.dao.IncorrectResultSizeDataAccessException
	 *         if multiple products match the code
	 */
 	Optional<Product> findByProductCode(String productCode);
}
