/**   
* @Title: EpRMonitorDeviceDAOiBatis.java 
* @Package com.megaeyes.persistence.ibatis.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-4-28 上午3:09:39 
* @version V1.0   
*/ 
package com.megaeyes.persistence.ibatis.impl;

import com.megaeyes.persistence.ibatis.iface.EpRMapDeviceDAOImpl;
import com.megaeyes.persistence.ibatis.iface.EpRMonitorDeviceDAOImpl;

/** 
 * @ClassName: EpRMonitorDeviceDAOiBatis 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-4-28 上午3:09:39 
 *  
 */
public class EpRMonitorDeviceDAOiBatis extends EpRMonitorDeviceDAOImpl {

	/**
	* @Title: deleteByAssetsId 
	* @Description: 根据资产管理ID删除关系表
	* @param assetsId
	* @return int    返回类型 
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public int deleteByDeviceId(String deviceId){
		int rows = getSqlMapClientTemplate().delete(
				"EP_R_MONITOR_DEVICE_VIEW.deleteByDeviceId",deviceId);
		return rows;
	}
	
	@SuppressWarnings("unchecked")
	public String getDeviceType(String deviceId){
		String rows = (String) getSqlMapClientTemplate().queryForObject(
				"EP_R_MONITOR_DEVICE_VIEW.getDeviceType",deviceId);
		return rows;
	}
	
	@SuppressWarnings("unchecked")
	public String getMonitorType(String monitorId){
		String rows = (String)getSqlMapClientTemplate().queryForObject(
				"EP_R_MONITOR_DEVICE_VIEW.getMonitorType",monitorId);
		return rows;
	}
}
