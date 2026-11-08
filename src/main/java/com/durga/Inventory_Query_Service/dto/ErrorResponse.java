package com.durga.Inventory_Query_Service.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Error body returned by the custom missing-product exception handler.
 * Contains the HTTP status, reason, exception message, and request URI.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {
	
	/** Server-local time when the error response was created, without a UTC offset. */
	private LocalDateTime timestamp;

	private int status;
	private String error;
	private String message;
	private String path;

}
