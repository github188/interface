package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.AcEmployeeGroup;

public class ListEmployeeGroupResponse extends BaseResponse{
	private String code;
	
	private List<AcEmployeeGroup> groups;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<AcEmployeeGroup> getGroups() {
		return groups;
	}

	public void setGroups(List<AcEmployeeGroup> groups) {
		this.groups = groups;
	}
	
}
