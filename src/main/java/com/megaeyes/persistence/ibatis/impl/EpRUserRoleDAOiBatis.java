/**   
 * @Title: EpRUserRoleDAOiBatis.java 
 * @Package com.megaeyes.persistence.ibatis.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-4-1 上午10:19:12 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.megaeyes.persistence.ibatis.iface.EpRUserRoleDAOImpl;
import com.megaeyes.persistence.ibatis.model.EpRole;

/**
 * @ClassName: EpRUserRoleDAOiBatis
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-4-1 上午10:19:12
 * 
 */
public class EpRUserRoleDAOiBatis extends EpRUserRoleDAOImpl {
	/**
	 * 
	* @Title: deleteByUserId 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param userId
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	public int deleteByUserId(String userId) {
		int rows = getSqlMapClientTemplate().delete(
				"EP_R_USER_ROLE_VIEW.deleteByUserId", userId);
		return rows;
	}
	
	/**
	 * 
	 * @Description: 查询用户是否具有云台控制权限
	 * @author zhuanqi@megaeyes.com
	 * @param @param userId
	 * @param @return 
	 * @return int 
	 * @throws
	 */
	public int checkUserPermissionByUserId(String userId,String operationNumber){
		Map<String,String> params = new HashMap<String,String>();
		params.put("userId", userId);
		params.put("operationNumber", operationNumber);
		int rows =  (Integer)getSqlMapClientTemplate().queryForObject(
				"EP_R_USER_ROLE_VIEW.checkUserPermissionByUserId", params);
		return rows;
	}
}
