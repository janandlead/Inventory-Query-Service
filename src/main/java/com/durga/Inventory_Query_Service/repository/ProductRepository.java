package com.durga.Inventory_Query_Service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.durga.Inventory_Query_Service.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	
 	Optional<Product> findByProductCode(String productCode);
}
