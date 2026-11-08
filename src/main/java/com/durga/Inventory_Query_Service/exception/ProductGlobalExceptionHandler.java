package com.durga.Inventory_Query_Service.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.durga.Inventory_Query_Service.dto.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Translates missing-product exceptions into structured HTTP 404 responses.
 */
@RestControllerAdvice
public class ProductGlobalExceptionHandler {

	/**
	 * Builds an error response containing the exception message and request URI.
	 *
	 * @param productNotFoundException failure raised by the product lookup
	 * @param httpServletRequest request that triggered the failure
	 * @return HTTP 404 with the error details and server-local timestamp
	 */
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleProductNotFoundException(
			ProductNotFoundException productNotFoundException, HttpServletRequest httpServletRequest) {

		ErrorResponse errorResponse = ErrorResponse.builder().timestamp(LocalDateTime.now())
				.status(HttpStatus.NOT_FOUND.value()).error(HttpStatus.NOT_FOUND.getReasonPhrase())
				.message(productNotFoundException.getMessage()).path(httpServletRequest.getRequestURI()).build();

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);

	}
}
