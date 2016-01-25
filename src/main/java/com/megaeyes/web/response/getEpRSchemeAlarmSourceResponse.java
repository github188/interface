/**   
 * @Title: getEpRSchemeAlarmSourceResponse.java 
 * @Package com.megaeyes.web.response 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-5-8 下午3:40:28 
 * @version V1.0   
 */
package com.megaeyes.web.response;

import java.util.List;

import org.json.JSONArray;

/**
 * @ClassName: getEpRSchemeAlarmSourceResponse
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-5-8 下午3:40:28
 * 
 */
public class getEpRSchemeAlarmSourceResponse extends BaseResponse {
	private List epRSchemeAlarmSource;
	private String code;

	public List getEpRSchemeAlarmSource() {
		return epRSchemeAlarmSource;
	}

	public void setEpRSchemeAlarmSource(List epRSchemeAlarmSource) {
		this.epRSchemeAlarmSource = epRSchemeAlarmSource;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
