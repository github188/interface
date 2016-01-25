/**   
 * @Title: listAOCTypeResponse.java 
 * @Package com.megaeyes.web.response 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-5-2 下午4:58:08 
 * @version V1.0   
 */
package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.AlarmOutputChannelType;

/**
 * @ClassName: listAOCTypeResponse
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-5-2 下午4:58:08
 * 
 */
public class listAOCTypeResponse extends BaseResponse {
	private List<AlarmOutputChannelType> list;
	private String code;

	public List<AlarmOutputChannelType> getList() {
		return list;
	}

	public void setList(List<AlarmOutputChannelType> list) {
		this.list = list;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
