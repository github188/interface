package com.megaeyes.access.exception;

public class GetDevicesVersionFailException extends ProtocolException {

	public GetDevicesVersionFailException() {
	}

	public GetDevicesVersionFailException(String message) {
		super(message);
	}

	public GetDevicesVersionFailException(String message, Throwable cause) {
		super(message, cause);
	}

	public GetDevicesVersionFailException(Throwable cause) {
		super(cause);
	}
}