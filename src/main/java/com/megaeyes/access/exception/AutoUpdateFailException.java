package com.megaeyes.access.exception;

public class AutoUpdateFailException extends ProtocolException {

	public AutoUpdateFailException() {
	}

	public AutoUpdateFailException(String message) {
		super(message);
	}

	public AutoUpdateFailException(String message, Throwable cause) {
		super(message, cause);
	}

	public AutoUpdateFailException(Throwable cause) {
		super(cause);
	}
}