package com.bespoke.exceptions;

public class WaterFeedException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WaterFeedException() {

	}

	public WaterFeedException(String message) {
		super(message);
	}

	public WaterFeedException(Throwable cause) {
		super(cause);
	}

	public WaterFeedException(String message, Throwable cause) {
		super(message, cause);
	}

}
