package com.durga.Inventory_Query_Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Bootstraps the inventory query HTTP service and its persistence components.
 */
@SpringBootApplication
public class InventoryQueryServiceApplication {

	/**
	 * Starts the Spring application.
	 *
	 * @param args command-line arguments passed to Spring Boot
	 */
	public static void main(String[] args) {
		SpringApplication.run(InventoryQueryServiceApplication.class, args);
	}

}
