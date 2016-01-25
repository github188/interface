/**   
 * @Title: BaseResponse.java 
 * @Package com.megaeyes.web.response 
 * @Description: 返回类的基类
 * @author liugaofeng liugaofeng@megaeyes.com   
 * @date 2012-2-28 下午5:34:33 
 * @version V1.0   
 */
package com.megaeyes.web.response;

import com.megaeyes.service.exception.ErrorCode;

/**
 * @ClassName: BaseResponse
 * @Description: 返回类的基类
 * @author liugaofeng liugaofeng@megaeyes.com
 * @date 2012-2-28 下午5:34:33
 * 
 */
public class BaseResponse {
	/** 
	* @Fields code :  @see ErrorCode
	*/ 
	private String code = ErrorCode.SUCCESS;

	/** 
	* @Fields message : 错误信息的描述
	*/ 
	private String message = "";
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
