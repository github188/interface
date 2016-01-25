package com.megaeyes.access.exception;

public class InvalidConfigurationException extends ProxyAppRuntimeException {

	public InvalidConfigurationException() {
	}

	public InvalidConfigurationException(String message) {
		super(message);
	}

	public InvalidConfigurationException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidConfigurationException(Throwable cause) {
		super(cause);
	}
}