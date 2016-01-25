/**   
 * @Title: AcEmployeesDAOiBatis.java 
 * @Package com.megaeyes.persistence.ibatis.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author wangbinyu wangbinyu@megaeyes.com   
 * @date 2012-4-24 上午1:52:04 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.impl;

import java.util.List;

import com.megaeyes.persistence.ibatis.iface.AcEmployeesDAOImpl;
import com.megaeyes.persistence.ibatis.model.AcEmployees;
import com.megaeyes.persistence.ibatis.vo.AcEmployeesVO;

/**
 * @ClassName: AcEmployeesDAOiBatis
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-4-24 上午1:52:04
 * 
 */
public class AcEmployeesDAOiBatis extends AcEmployeesDAOImpl {

	/**
	 * @Title: listAcEmployees
	 * @Description: 查询职员列表
	 * @return List<AcEmployees> 返回类型
	 * @throws
	 */
	public List<AcEmployeesVO> listAcEmployees() {
		return getSqlMapClientTemplate().queryForList(
				"AC_EMPLOYEES_VIEW.listAcEmployees");
	}

	public List<AcEmployeesVO> listAcEmployeesByBranchId(String branchId) {
		return getSqlMapClientTemplate().queryForList(
				"AC_EMPLOYEES_VIEW.listAcEmployeesByBranchId", branchId);
	}

	public AcEmployees getAcEmployeeByCardNumber(String cardNumber) {
		return (AcEmployees) getSqlMapClientTemplate().queryForObject(
				"AC_EMPLOYEES_VIEW.getAcEmployeeByCardNumber", cardNumber);
	}

	public List<AcEmployeesVO> getAcEmployeeListByGroupId(String groupId) {
		return getSqlMapClientTemplate().queryForList(
				"AC_EMPLOYEES_VIEW.getAcEmployeeListByGroupId", groupId);
	}
}
