package com.megaeyes.access.exception;

/**
 * 所有设备异常的父类。
 * <p>
 * Title: megaeyes
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author not attributable
 * @version 1.0
 */
public class DeviceException extends ProxyAppException {
	public DeviceException() {
	}

	public DeviceException(String message) {
		super(message);
	}

	public DeviceException(String message, Throwable cause) {
		super(message, cause);
	}

	public DeviceException(Throwable cause) {
		super(cause);
	}

}