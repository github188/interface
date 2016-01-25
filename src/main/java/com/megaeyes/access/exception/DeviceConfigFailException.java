package com.megaeyes.access.exception;

/**
 * 设备配置失败
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

public class DeviceConfigFailException extends DeviceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4819106378816308775L;

	public DeviceConfigFailException() {
	}

	public DeviceConfigFailException(String message) {
		super(message);
	}

	public DeviceConfigFailException(String message, Throwable cause) {
		super(message, cause);
	}

	public DeviceConfigFailException(Throwable cause) {
		super(cause);
	}
}