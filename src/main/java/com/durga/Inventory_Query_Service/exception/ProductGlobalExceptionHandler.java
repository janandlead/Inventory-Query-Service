package com.durga.Inventory_Query_Service.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.durga.Inventory_Query_Service.dto.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ProductGlobalExceptionHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleProductNotFoundException(
			ProductNotFoundException productNotFoundException, HttpServletRequest httpServletRequest) {

		ErrorResponse errorResponse = ErrorResponse.builder().timestamp(LocalDateTime.now())
				.status(HttpStatus.NOT_FOUND.value()).error(HttpStatus.NOT_FOUND.getReasonPhrase())
				.message(productNotFoundException.getMessage()).path(httpServletRequest.getRequestURI()).build();

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);

	}
}
