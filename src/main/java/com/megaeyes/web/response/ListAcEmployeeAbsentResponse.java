package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.vo.AcEmployeeAbsentRecordVO;

public class ListAcEmployeeAbsentResponse extends BaseResponse {

	private List<AcEmployeeAbsentRecordVO> absents;

	public List<AcEmployeeAbsentRecordVO> getAbsents() {
		return absents;
	}

	public void setAbsents(List<AcEmployeeAbsentRecordVO> absents) {
		this.absents = absents;
	}
}
