package com.megaeyes.access.exception;

public class CppNotifyFailException extends UserSessionException {

	public CppNotifyFailException() {
	}

	public CppNotifyFailException(String message) {
		super(message);
	}

	public CppNotifyFailException(String message, Throwable cause) {
		super(message, cause);
	}

	public CppNotifyFailException(Throwable cause) {
		super(cause);
	}
}