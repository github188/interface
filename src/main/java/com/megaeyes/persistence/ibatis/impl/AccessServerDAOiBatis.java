/**   
* @Title: AccessServerDAOiBatis.java 
* @Package com.megaeyes.persistence.ibatis.impl 
* @Description: TODO(接入服务器自定义方法) 
* @author wangbinyu wangbinyu@megaeyes.com    
* @date 2012-2-27 下午4:15:41 
* @version V1.0   
*/ 
package com.megaeyes.persistence.ibatis.impl;

import java.util.List;

import com.megaeyes.persistence.ibatis.iface.AccessServerDAOImpl;
import com.megaeyes.persistence.ibatis.model.AccessServer;

/** 
 * @ClassName: AccessServerDAOiBatis 
 * @Description: TODO(接入服务器) 
 * @author wangbinyu wangbinyu@megaeyes.com 
 * @date 2012-2-27 下午4:15:41 
 *  
 */
public class AccessServerDAOiBatis extends AccessServerDAOImpl{
	/**
	* @Title: listAccessServer 
	* @Description: TODO(查询中心接入服务器列表) 
	* @param @return    接入服务器列表 
	* @return List<AccessServer>    返回类型 
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public List<AccessServer> listAccessServer() {
		return getSqlMapClientTemplate().queryForList(
				"ACCESS_SERVER_VIEW.listAccessServer");
	}
	
	public String getAccessServerIp1(String ip){
		return (String)getSqlMapClientTemplate().queryForObject(
				"ACCESS_SERVER_VIEW.getAccessServerIp1",ip);
	}

}
