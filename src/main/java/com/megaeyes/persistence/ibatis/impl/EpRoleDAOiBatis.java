/**   
 * @Title: EpRoleDAOiBatis.java 
 * @Package com.megaeyes.persistence.ibatis.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-3-31 上午11:21:29 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.impl;

import java.util.List;

import com.megaeyes.persistence.ibatis.iface.EpRoleDAOImpl;
import com.megaeyes.persistence.ibatis.model.EpRRoleResource;
import com.megaeyes.persistence.ibatis.model.EpRole;
import com.megaeyes.persistence.ibatis.vo.ListOperationByRoleId;

/**
 * @ClassName: EpRoleDAOiBatis
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-3-31 上午11:21:29
 * 
 */
public class EpRoleDAOiBatis extends EpRoleDAOImpl {

	/**
	 * @Title: listRoleByOrganId
	 * @Description: TODO(根据机构id查询角色列表)
	 * @param organId
	 * @param @return 设定文件
	 * @return List<EpRole> 返回类型
	 * @throws
	 */
	public List<EpRole> listRoleByOrganId(String organId) {
		return getSqlMapClientTemplate().queryForList(
				"EP_ROLE_VIEW.ListRoleByOrganId", organId);
	}

	/**
	 * 
	 * @Title: listRoleByUserId
	 * @Description: TODO(根据用户ID查询角色列表)
	 * @param userId
	 * @param @return 设定文件
	 * @return List<EpRole> 返回类型
	 * @throws
	 */
	public List<EpRole> listRoleByUserId(String userId) {
		return getSqlMapClientTemplate().queryForList(
				"EP_ROLE_VIEW.listRoleByUserId", userId);
	}

	/**
	 * @Title: listOperationByRoleId
	 * @Description: TODO(根据角色查询权限)
	 * @param @param roleId
	 * @param @return 设定文件
	 * @return List<ListOperationByRoleId> 返回类型
	 * @throws
	 */
	public List<ListOperationByRoleId> listOperationByRoleId(String roleId) {
		return getSqlMapClientTemplate().queryForList(
				"EP_ROLE_VIEW.listOperationByRoleId", roleId);
	}

}
