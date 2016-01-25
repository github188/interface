package com.megaeyes.persistence.ibatis.impl;

import java.util.List;

import com.megaeyes.persistence.ibatis.iface.AcREmployeeCardDAOImpl;
import com.megaeyes.persistence.ibatis.vo.ListCardAndEmployeeVO;
import com.megaeyes.persistence.ibatis.vo.ListEmployeesAndCardVO;

/**
 * AcREmployeeCardDAOiBatis(类说明)
 * @author wangbinyu wangbinyu@megaeyes.com
 * <p />
 * 2012-5-18 上午02:15:31
 */
public class AcREmployeeCardDAOiBatis extends AcREmployeeCardDAOImpl {

	/**
	 * 
	 * listEmployeesAndCard 查询绑定卡和员工列表
	 * @return List<ListEmployeesAndCardVO>
	 */
	public List<ListEmployeesAndCardVO> listEmployeesAndCard(String organId) {
		return getSqlMapClientTemplate().queryForList(
				"AC_ACCESS_CARDS_VIEW.listEmployeesAndCard",organId);
	}

	/**
	 * 
	 * listCardAndEmployee 根据门ID查询卡和员工信息列表
	 * @param doorId 门ID
	 * @return List<ListCardAndEmployeeVO>
	 */
	public List<ListCardAndEmployeeVO> listCardAndEmployee(String doorId) {
		return getSqlMapClientTemplate().queryForList(
		"AC_ACCESS_CARDS_VIEW.listCardAndEmployee",doorId);
	}

	
}
