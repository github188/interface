/**   
* @Title: EpRMapDeviceDAOiBatis.java 
* @Package com.megaeyes.persistence.ibatis.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author tangjianyang tangjianyang@megaeyes.com   
* @date 2012-3-21 下午4:43:51 
* @version V1.0   
*/ 
package com.megaeyes.persistence.ibatis.impl;

import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

import com.megaeyes.persistence.ibatis.iface.EpRMapDeviceDAOImpl;

/** 
 * @ClassName: EpRMapDeviceDAOiBatis 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author tangjianyang tangjianyang@megaeyes.com  
 * @date 2012-3-21 下午4:43:51 
 *  
 */
public class EpRMapDeviceDAOiBatis extends EpRMapDeviceDAOImpl {
	

	/**
	 * 根据设备删除设备与地图的绑定关系
	 * 
	 * @param mapId
	 *            地图ID，如果为空将会删除所有此设备的地图绑定关系
	 * @param deviceId
	 *            设备ID
	 * @param deviceType
	 *            设备类型
	 */
	public void deleteEpRMapDeviceByDeviceId(String mapId, String deviceId,
			String deviceType) {
		Map parm = new HashedMap();
		parm.put("mapId", mapId);
		parm.put("deviceId", deviceId);
		parm.put("deviceType", deviceType);
		getSqlMapClientTemplate().delete(
				"EP_R_MAP_DEVICE_VIEW.deleteEpRMapDeviceByDeviceId", parm);
	}

}
