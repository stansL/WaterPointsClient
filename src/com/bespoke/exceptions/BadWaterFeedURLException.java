package com.bespoke.exceptions;

public class BadWaterFeedURLException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BadWaterFeedURLException() {

	}

	public BadWaterFeedURLException(String message) {
		super(message);
	}

	public BadWaterFeedURLException(Throwable cause) {
		super(cause);
	}

	public BadWaterFeedURLException(String message, Throwable cause) {
		super(message, cause);
	}

}
