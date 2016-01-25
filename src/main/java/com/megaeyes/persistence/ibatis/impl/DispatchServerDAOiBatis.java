/**   
* @Title: DispatchServerDAOiBatis.java 
* @Package com.megaeyes.persistence.ibatis.impl 
* @Description: TODO(分发服务器自定义方法) 
* @author wangbinyu wangbinyu@megaeyes.com    
* @date 2012-2-27 下午4:20:40 
* @version V1.0   
*/ 
package com.megaeyes.persistence.ibatis.impl;

import java.util.List;

import com.megaeyes.persistence.ibatis.iface.DispatchServerDAOImpl;
import com.megaeyes.persistence.ibatis.model.DispatchServer;

/** 
 * @ClassName: DispatchServerDAOiBatis 
 * @Description: TODO(分发服务器) 
 * @author wangbinyu wangbinyu@megaeyes.com 
 * @date 2012-2-27 下午4:20:40 
 *  
 */
public class DispatchServerDAOiBatis extends DispatchServerDAOImpl {
	/**
	 * 
	* @Title: listDispatchServer 
	* @Description: TODO(查询中心分发服务器列表) 
	* @param @return    分发服务器列表 
	* @return List<DispatchServer>    返回类型 
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public List<DispatchServer> listDispatchServer() {
		return getSqlMapClientTemplate().queryForList(
				"DISPATCH_SERVER_VIEW.listDispatchServer");
	}
}
