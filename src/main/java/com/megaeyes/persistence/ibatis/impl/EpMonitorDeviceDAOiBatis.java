/**   
* @Title: EpMonitorDeviceDAOiBatis.java 
* @Package com.megaeyes.persistence.ibatis.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-4-27 上午3:25:15 
* @version V1.0   
*/ 
package com.megaeyes.persistence.ibatis.impl;

import java.util.List;

import com.megaeyes.persistence.ibatis.iface.EpMonitorDeviceDAOImpl;
import com.megaeyes.persistence.ibatis.model.AccessServer;
import com.megaeyes.persistence.ibatis.model.EpMonitorDevice;

/** 
 * @ClassName: EpMonitorDeviceDAOiBatis 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-4-27 上午3:25:15 
 *  
 */
public class EpMonitorDeviceDAOiBatis extends EpMonitorDeviceDAOImpl {
	
	/**
	* @Title: listEMD 
	* @Description: 查询监控设备列表
	* @return List<EpMonitorDevice>    返回类型 
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public List<EpMonitorDevice> listEMD() {
		return getSqlMapClientTemplate().queryForList(
				"EP_MONITOR_DEVICE_VIEW.listEMD");
	}
}
