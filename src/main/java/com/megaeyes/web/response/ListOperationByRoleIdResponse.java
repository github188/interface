/**   
 * @Title: ListOperationByRoleIdResponse.java 
 * @Package com.megaeyes.web.response 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-4-6 下午5:04:42 
 * @version V1.0   
 */
package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.vo.ListOperationByRoleId;

/**
 * @ClassName: ListOperationByRoleIdResponse
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-4-6 下午5:04:42
 * 
 */
public class ListOperationByRoleIdResponse extends BaseResponse {
	private List<ListOperationByRoleId> list;

	public List<ListOperationByRoleId> getList() {
		return list;
	}

	public void setList(List<ListOperationByRoleId> list) {
		this.list = list;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	private String code;
}
