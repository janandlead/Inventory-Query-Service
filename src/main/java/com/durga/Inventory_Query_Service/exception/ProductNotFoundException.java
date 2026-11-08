package com.durga.Inventory_Query_Service.exception;

/**
 * Signals that a product-code lookup found no inventory record.
 */
public class ProductNotFoundException extends RuntimeException{
	/**
	 * Creates an exception whose message is exposed in the HTTP 404 response.
	 *
	 * @param message description of the missing product
	 */
	public ProductNotFoundException(String message) {
		super(message);
	}
}
