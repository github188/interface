package com.megaeyes.persistence.ibatis.impl;

import java.util.List;

import com.megaeyes.persistence.ibatis.iface.AcEmployeeGroupDAOImpl;
import com.megaeyes.persistence.ibatis.model.AcEmployeeGroup;

/**
 * 
 * @Title: AcEmployeeGroupDAOiBatis.java
 * @Package com.megaeyes.persistence.ibatis.impl
 * @Description: TODO(用一句话描述该文件做什么)
 * @author zhuanqi@megaeyes.com
 * @date 2013-1-11 上午02:52:45
 * @version V2.5
 */
public class AcEmployeeGroupDAOiBatis extends AcEmployeeGroupDAOImpl {

	@SuppressWarnings("unchecked")
	public List<AcEmployeeGroup> getGroupListByScheduleId(String scheduleId) {
		return getSqlMapClientTemplate().queryForList(
				"AC_EMPLOYEE_GROUP_VIEW.getGroupListByScheduleId", scheduleId);
	}
}
