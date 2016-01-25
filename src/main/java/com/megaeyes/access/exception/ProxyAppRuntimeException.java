package com.megaeyes.access.exception;

/**
 * 
 * @Title: ProxyAppRuntimeException.java
 * @Package com.megaeyes.access.exception
 * @Description: TODO(用一句话描述该文件做什么)
 * @author zhuanqi@megaeyes.com
 * @date 2012-9-19 上午08:59:47
 * @version V1.0s
 */
public class ProxyAppRuntimeException extends ApplicationRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8722225106219292023L;

	public ProxyAppRuntimeException() {
	}

	public ProxyAppRuntimeException(String message) {
		super(message);
	}

	public ProxyAppRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProxyAppRuntimeException(Throwable cause) {
		super(cause);
	}
}