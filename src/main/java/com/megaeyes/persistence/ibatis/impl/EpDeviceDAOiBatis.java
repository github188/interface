/**   
* @Title: EpDeviceDAOiBatis.java 
* @Package com.megaeyes.persistence.ibatis.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-4-25 上午6:53:44 
* @version V1.0   
*/ 
package com.megaeyes.persistence.ibatis.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.megaeyes.persistence.ibatis.iface.EpDeviceDAOImpl;
import com.megaeyes.persistence.ibatis.model.AccessServer;
import com.megaeyes.persistence.ibatis.model.EpDevice;
import com.megaeyes.persistence.ibatis.vo.ListDeviceByIntelligentVO;
import com.megaeyes.persistence.ibatis.vo.ListVicVO;

/** 
 * @ClassName: EpDeviceDAOiBatis 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-4-25 上午6:53:44 
 *  
 */
public class EpDeviceDAOiBatis extends EpDeviceDAOImpl {

	/**
	* @Title: listEDLByOrganId 
	* @Description: 根据机构ID查询线路列表
	* @return List<EpDevice>    返回类型 
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public List<EpDevice> listEDLByOrganId(String organId) {
		return getSqlMapClientTemplate().queryForList(
				"EP_DEVICE_VIEW.listEDLByOrganId",organId);
	}
	
	/**
	* @Title: listDeviceByDeviceId 
	* @Description: 根据设备ID查询监控设备列表 
	* @param assetsId
	* @return List<ListVicVO>    返回类型 
	* @throws 
	 */
	@SuppressWarnings("unchecked")
	public List<ListVicVO> listDeviceByDeviceId(String deviceId) {
		return getSqlMapClientTemplate().queryForList(
				"EP_DEVICE_VIEW.listDeviceByDeviceId",deviceId);
	}

	/**
	* @Title: listDeviceByIntelligentId 
	* @Description: 根据智能监测设备ID查询设备信息
	* @param  intelligentId 智能监测设备ID
	* @return List<ListDeviceByIntelligentVO>    返回类型 
	* @throws
	 */
	public List<ListDeviceByIntelligentVO> listDeviceByIntelligentId(
			String intelligentId,String organId) {
		Map map = new HashMap();
		map.put("intelligentId", intelligentId);
		map.put("organId",organId);
		return getSqlMapClientTemplate().queryForList(
				"EP_DEVICE_VIEW.listDeviceByIntelligentId",map);
	}

	/**
	 * 
	 * selectDomainsByOrganId 根据机构ID查询区域
	 * @param organId
	 * @return List
	 */
	public List listDomainsByOrganId(String organId) {
		return getSqlMapClientTemplate().queryForList(
				"EP_DEVICE_VIEW.listDomainsByOrganId",organId);
	}
	
}
