package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.AcEmployeeGroup;

public class ListAcEmployeeGroupsResponse extends BaseResponse {

	public List<AcEmployeeGroup> employeeGroups;

	public List<AcEmployeeGroup> getEmployeeGroups() {
		return employeeGroups;
	}

	public void setEmployeeGroups(List<AcEmployeeGroup> employeeGroups) {
		this.employeeGroups = employeeGroups;
	}
}
