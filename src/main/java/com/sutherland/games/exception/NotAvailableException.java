package com.sutherland.games.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotAvailableException extends RuntimeException {

	private static final long serialVersionUID = -6793498679912377453L;

	private String message;

	public NotAvailableException(String message) {
		this.message = message;
	}

}
