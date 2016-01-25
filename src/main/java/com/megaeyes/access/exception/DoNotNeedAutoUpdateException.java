package com.megaeyes.access.exception;

public class DoNotNeedAutoUpdateException extends ProtocolException {

	public DoNotNeedAutoUpdateException() {
	}

	public DoNotNeedAutoUpdateException(String message) {
		super(message);
	}

	public DoNotNeedAutoUpdateException(String message, Throwable cause) {
		super(message, cause);
	}

	public DoNotNeedAutoUpdateException(Throwable cause) {
		super(cause);
	}
}