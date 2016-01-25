package com.megaeyes.web.response.xml;

/**
 * xml接口返回对象超类
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2012-4-16 下午03:04:30
 */
public class BaseXMLResponse {
	public static final String SUCCESS = "Y";
	public static final String FAIL = "N";
	public static final String AUTH_FAIL = "403";
	public static final String ACCOUNT_ERROR = "404";
	public static final String EXCEPTION = "500";

	private String success = SUCCESS;

	private String reason = "";

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
