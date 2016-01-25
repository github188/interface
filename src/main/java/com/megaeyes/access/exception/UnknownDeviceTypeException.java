package com.megaeyes.access.exception;

/**
 * 
 * @Title: UnknownDeviceTypeException.java
 * @Package com.megaeyes.access.exception
 * @Description: 未知设备类型异常
 * @author zhuanqi@megaeyes.com
 * @date 2012-9-19 上午08:35:51
 * @version V1.0
 */
public class UnknownDeviceTypeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -724340680431177499L;

	public UnknownDeviceTypeException() {
	}

	public UnknownDeviceTypeException(String message) {
		super(message);
	}

	public UnknownDeviceTypeException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnknownDeviceTypeException(Throwable cause) {
		super(cause);
	}
}