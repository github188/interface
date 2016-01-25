package com.megaeyes.persistence.ibatis.vo;

import com.megaeyes.persistence.ibatis.model.AcEmployeeAbsenceRecord;

public class AcEmployeeAbsentRecordVO extends AcEmployeeAbsenceRecord{

	private String employeeName;

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
}
