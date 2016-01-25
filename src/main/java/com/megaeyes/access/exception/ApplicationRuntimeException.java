package com.megaeyes.access.exception;

/**
 * 
 * @Title: ApplicationRuntimeException.java 
 * @Package com.megaeyes.access.exception 
 * @Description: 运行时异常类 
 * @author zhuanqi@megaeyes.com   
 * @date 2012-9-19 上午08:59:08 
 * @version V1.0
 */
public abstract class ApplicationRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6948065065685914722L;

	protected ApplicationRuntimeException() {

		super();
	}

	public ApplicationRuntimeException(String message) {

		super(message);
	}

	public ApplicationRuntimeException(Throwable cause) {

		super(cause);
	}

	public ApplicationRuntimeException(String message, Throwable cause) {

		super(message, cause);
	}

}