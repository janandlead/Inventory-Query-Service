package com.durga.Inventory_Query_Service.exception;

public class ProductNotFoundException extends RuntimeException{
	public ProductNotFoundException(String message) {
		super(message);
	}
}
