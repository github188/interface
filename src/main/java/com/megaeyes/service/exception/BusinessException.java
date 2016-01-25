/**   
 * @Title: BusinessException.java 
 * @Package com.megaeyes.service.exception 
 * @Description: 业务层异常基类
 * @author liugaofeng liugaofeng@megaeyes.com   
 * @date 2012-2-27 下午2:22:00 
 * @version V1.0   
 */
package com.megaeyes.service.exception;

/**
 * @ClassName: BusinessException
 * @Description: 业务层异常基类
 * @author liugaofeng liugaofeng@megaeyes.com
 * @date 2012-2-27 下午2:22:00
 * 
 */
public class BusinessException extends RuntimeException {

	public BusinessException(String message, String code) {
		super();
		this.message = message;
		this.code = code;
	}

	/**
	 * @Fields message :用于保存抛出该异常的原因
	 */
	private String message;

	/**
	 * @Fields code : 错误编码
	 */
	private String code;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
