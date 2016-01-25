package com.megaeyes.access.exception;


/**
 * 所有proxy应用异常的父类。
 * <p>
 * Title: megaeyes
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author not attributable
 * @version 1.0
 */
public class ProxyAppException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8733364848051469272L;

	public ProxyAppException() {
	}

	public ProxyAppException(String message) {
		super(message);
	}

	public ProxyAppException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProxyAppException(Throwable cause) {
		super(cause);
	}

}