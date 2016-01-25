package com.megaeyes.access.exception;

/**
 * 
 * @Title: UnknownOperationTypeException.java
 * @Package com.megaeyes.access.exception
 * @Description: 操作日志异常
 * @author zhuanqi@megaeyes.com
 * @date 2012-9-19 上午08:27:41
 * @version V1.0
 */
public class UnknownOperationTypeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6761066143851160074L;

	public UnknownOperationTypeException() {

	}

	public UnknownOperationTypeException(String message) {
		super(message);
	}

	public UnknownOperationTypeException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnknownOperationTypeException(Throwable cause) {
		super(cause);
	}
}