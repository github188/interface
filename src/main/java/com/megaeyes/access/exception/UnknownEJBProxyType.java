package com.megaeyes.access.exception;

public class UnknownEJBProxyType extends ProxyAppRuntimeException {

	public UnknownEJBProxyType() {
	}

	public UnknownEJBProxyType(String message) {
		super(message);
	}

	public UnknownEJBProxyType(String message, Throwable cause) {
		super(message, cause);
	}

	public UnknownEJBProxyType(Throwable cause) {
		super(cause);
	}
}