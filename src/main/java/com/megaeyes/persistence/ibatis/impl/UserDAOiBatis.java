/**   
 * @Title: UserDAOiBatis.java 
 * @Package com.megaeyes.persistence.ibatis.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-3-2 下午1:47:35 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.impl;

import java.util.List;

import com.megaeyes.persistence.ibatis.iface.TUserDAOImpl;
import com.megaeyes.persistence.ibatis.model.TUser;
import com.megaeyes.persistence.ibatis.vo.ListUserSessionAndUserVO;
import com.megaeyes.persistence.ibatis.vo.TUserVO;

/**
 * @ClassName: UserDAOiBatis
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-3-2 下午1:47:35
 * 
 */
public class UserDAOiBatis extends TUserDAOImpl {

	/**
	 * @Title: listDispatchServer
	 * @Description: 查询用户列表
	 * @param @return 设定文件
	 * @return List<TUser> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<TUser> listUser() {
		return getSqlMapClientTemplate().queryForList("T_USER_VIEW.listUser");
	}

	/**
	 * @Title: getUsersByOrganId
	 * @Description: TODO()
	 * @param @param organId
	 * @param @return 设定文件
	 * @return List<TUser> 返回类型
	 * @throws
	 */
	public List<TUserVO> getUsersByOrganId(String organId) {
		return getSqlMapClientTemplate().queryForList(
				"T_USER_VIEW.getUsersByOrganId", organId);
	}

	/**
	 * @Title: getAllChildUsersByOrganId
	 * @Description: TODO(根据机构id查询所有子机构用户)
	 * @param organId
	 * @return 设定文件
	 * @return List<TUser> 返回类型
	 * @throws
	 */
	public List<TUser> getAllChildUsersByOrganId(String organId) {
		return getSqlMapClientTemplate().queryForList(
				"T_USER_VIEW.getAllChildUsersByOrganId", organId);
	}

	/**
	 * 
	 * listUserSessionAndUserLogName 查询在线用户列表
	 * @return List<ListUserSessionAndUserVO>
	 */
	public List<ListUserSessionAndUserVO> listUserSessionAndUserLogName() {
		return getSqlMapClientTemplate().queryForList(
				"T_USER_VIEW.listUserSessionAndUserLogName");
	}
}
