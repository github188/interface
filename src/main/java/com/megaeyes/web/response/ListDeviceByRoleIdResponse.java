/**   
 * @Title: ListDeviceByRoleIdResponse.java 
 * @Package com.megaeyes.web.response 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-4-9 下午4:22:09 
 * @version V1.0   
 */
package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.vo.ListDeviceByRoleId;

/**
 * @ClassName: ListDeviceByRoleIdResponse
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-4-9 下午4:22:09
 * 
 */
public class ListDeviceByRoleIdResponse extends BaseResponse {
	private List<ListDeviceByRoleId> list;
	private String code;

	public List<ListDeviceByRoleId> getList() {
		return list;
	}

	public void setList(List<ListDeviceByRoleId> list) {
		this.list = list;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
