package com.megaeyes.service.exception;

/**
 * 
 * @Title: ParameterUnavailableException.java 
 * @Package com.megaeyes.service.exception 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zhuanqi@megaeyes.com   
 * @date 2013-1-8 上午08:19:53 
 * @version V2.5
 */
public class ParameterUnavailableException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5877930004883288473L;
	
	public ParameterUnavailableException() {
	}

	public ParameterUnavailableException(String message) {
		super(message);
	}

	public ParameterUnavailableException(String message, Throwable cause) {
		super(message, cause);
	}

	public ParameterUnavailableException(Throwable cause) {
		super(cause);
	}
}
