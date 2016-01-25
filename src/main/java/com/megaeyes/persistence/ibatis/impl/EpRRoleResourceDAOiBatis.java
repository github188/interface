/**   
 * @Title: EpRRoleResourceDAOiBatis.java 
 * @Package com.megaeyes.persistence.ibatis.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-4-9 下午1:43:19 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.impl;

import java.util.List;

import com.megaeyes.persistence.ibatis.iface.EpRRoleResourceDAOImpl;
import com.megaeyes.persistence.ibatis.model.EpRRoleResource;
import com.megaeyes.persistence.ibatis.vo.ListDeviceByRoleId;

/**
 * @ClassName: EpRRoleResourceDAOiBatis
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-4-9 下午1:43:19
 * 
 */
public class EpRRoleResourceDAOiBatis extends EpRRoleResourceDAOImpl {
	/**
	 * @Title: deleteByRoleId
	 * @Description: TODO(根据roleid删除)
	 * @param @param roleId
	 * @param @return 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	public int deleteByRoleId(String roleId) {
		int rows = getSqlMapClientTemplate().delete(
				"EP_R_ROLE_RESOURCE_VIEW.deleteByRoleId", roleId);
		return rows;
	}

	/**
	 * @Title: listDeviceByRoleId
	 * @Description: TODO(根据角色查询设备)
	 * @param @param roleId
	 * @param @return 设定文件
	 * @return List<EpRRoleResource> 返回类型
	 * @throws
	 */
	public List<ListDeviceByRoleId> listVICByRoleId(String roleId) {
		return getSqlMapClientTemplate().queryForList(
				"EP_R_ROLE_RESOURCE_VIEW.listvicByRoleId", roleId);
	}
}
