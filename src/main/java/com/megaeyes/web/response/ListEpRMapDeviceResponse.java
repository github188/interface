/**   
 * @Title: ListEpRMapDeviceResponse.java 
 * @Package com.megaeyes.web.response 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-4-28 下午4:32:08 
 * @version V1.0   
 */
package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.EpRMapDevice;

/**
 * @ClassName: ListEpRMapDeviceResponse
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-4-28 下午4:32:08
 * 
 */
public class ListEpRMapDeviceResponse extends BaseResponse {
	private List<EpRMapDevice> list;
	private String code;

	public List<EpRMapDevice> getList() {
		return list;
	}

	public void setList(List<EpRMapDevice> list) {
		this.list = list;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
