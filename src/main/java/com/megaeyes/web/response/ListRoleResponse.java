/**   
 * @Title: ListRoleResponse.java 
 * @Package com.megaeyes.web.response 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-3-31 下午5:55:13 
 * @version V1.0   
 */
package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.EpRole;

/**
 * @ClassName: ListRoleResponse
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-3-31 下午5:55:13
 * 
 */
public class ListRoleResponse extends BaseResponse {
	private List<EpRole> listrole;
	private String code;

	public List<EpRole> getListrole() {
		return listrole;
	}

	public void setListrole(List<EpRole> listrole) {
		this.listrole = listrole;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
