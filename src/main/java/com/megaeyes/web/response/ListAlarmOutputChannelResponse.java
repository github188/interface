/**   
 * @Title: ListAlarmOutputChannelResponse.java 
 * @Package com.megaeyes.web.response 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-3-27 上午10:31:31 
 * @version V1.0   
 */
package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.AlarmOutputChannel;

/**
 * @ClassName: ListAlarmOutputChannelResponse
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-3-27 上午10:31:31
 * 
 */
public class ListAlarmOutputChannelResponse extends BaseResponse {
	private List<AlarmOutputChannel> aocs;
	private String code;

	public List<AlarmOutputChannel> getAocs() {
		return aocs;
	}

	public void setAocs(List<AlarmOutputChannel> aocs) {
		this.aocs = aocs;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
