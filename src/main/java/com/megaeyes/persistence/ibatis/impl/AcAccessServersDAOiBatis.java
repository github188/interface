/**   
* @Title: AcAccessServerDAOiBatis.java 
* @Package com.megaeyes.persistence.ibatis.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-5-14 上午8:32:13 
* @version V1.0   
*/ 
package com.megaeyes.persistence.ibatis.impl;

import com.megaeyes.persistence.ibatis.iface.AcAccessControlsDAOImpl;
import com.megaeyes.persistence.ibatis.iface.AcAccessServersDAOImpl;

/** 
 * @ClassName: AcAccessServerDAOiBatis 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-5-14 上午8:32:13 
 *  
 */
public class AcAccessServersDAOiBatis extends AcAccessServersDAOImpl {

	/**
	* @Title: getIpByGateWayId 
	* @Description: 根据门禁网关ID查询IP
	* @param gateWayId 门禁网关ID
	* @return String    返回类型 
	* @throws
	 */
	public String getIpByGateWayId(String gatewayId) {
		String gatewayIp = (String) getSqlMapClientTemplate().queryForObject(
				"AC_ACCESS_SERVERS_VIEW.getIpByGateWayId",gatewayId);
		System.out.println("gatewayIp"+gatewayIp);
		return gatewayIp;
	}

	
	/**
	* @Title: deleteAcAccessControlsByServersId 
	* @Description: 根据门禁控制器ID删除门信息
	* @param  id 门禁控制器ID
	* @return int    返回类型 
	* @throws
	 */
	public int deleteAcAccessControlsByServersId(String id) {
		int rows = getSqlMapClientTemplate().delete(
				"AC_ACCESS_SERVERS_VIEW.deleteAcAccessControlsByServersId",id);
		return rows;
	}

	
}
