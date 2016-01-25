package com.megaeyes.persistence.ibatis.impl;

import java.util.List;

import com.megaeyes.persistence.ibatis.iface.AcEmployeeAbsenceRecordDAOImpl;
import com.megaeyes.persistence.ibatis.vo.AcEmployeeAbsentRecordVO;

public class AcEmployeeAbsenceRecordDAOiBatis extends AcEmployeeAbsenceRecordDAOImpl {

	@SuppressWarnings("unchecked")
	public List<AcEmployeeAbsentRecordVO> getAbsentListByBranchId(String branchId) {
		return getSqlMapClientTemplate().queryForList(
				"AC_EMPLOYEE_ABSENT_RECORD_VIEW.getAbsentListByBranchId", branchId);
	}
}
