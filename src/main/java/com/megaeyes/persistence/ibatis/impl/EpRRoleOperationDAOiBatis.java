/**   
 * @Title: EpRRoleOperationDAOiBatis.java 
 * @Package com.megaeyes.persistence.ibatis.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-4-6 上午10:29:37 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.impl;

import com.megaeyes.persistence.ibatis.iface.EpRRoleOperationDAOImpl;

/**
 * @ClassName: EpRRoleOperationDAOiBatis
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-4-6 上午10:29:37
 * 
 */
public class EpRRoleOperationDAOiBatis extends EpRRoleOperationDAOImpl {
	/**
	 * 
	 * @Title: deleteRoleId
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param RoleId
	 * @param @return 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	public int deleteByRoleId(String roleId) {
		int rows = getSqlMapClientTemplate().delete(
				"EP_R_ROLE_OPERATION_VIEW.deleteByRoleId", roleId);
		return rows;
	}

	public void adminUser(String id) {
		System.out.println("-------------id:"+id);
		 getSqlMapClientTemplate().insert("EP_R_ROLE_OPERATION_VIEW.createAdminUser",id);
	}

	public void generalUser(String id) {
		getSqlMapClientTemplate()
				.insert("EP_R_ROLE_OPERATION_VIEW.createGeneralUser",id);
	}
}
