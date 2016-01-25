/**   
* @Title: EpProberDAOiBatis.java 
* @Package com.megaeyes.persistence.ibatis.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-4-18 上午6:59:37 
* @version V1.0   
*/ 
package com.megaeyes.persistence.ibatis.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.megaeyes.persistence.ibatis.iface.EpProberDAOImpl;
import com.megaeyes.persistence.ibatis.model.EpProber;
import com.megaeyes.persistence.ibatis.vo.EpProberVO;
import com.megaeyes.persistence.ibatis.vo.ListEpMonitorDeviceAndEpProberVO;
import com.megaeyes.persistence.ibatis.vo.ListVicIdVO;
import com.megaeyes.persistence.ibatis.vo.ListVicVO;

/** 
 * @ClassName: EpProberDAOiBatis 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-4-18 上午6:59:37 
 *  
 */
public class EpProberDAOiBatis extends EpProberDAOImpl {
	
	/**
	* @Title: deleteByDeviceId 
	* @Description: 根据太阳能ID删除探测器 
	* @param deviceId
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public int deleteEpProberByECSId(String id){
		int rows = getSqlMapClientTemplate().delete(
				"EP_PROBER_VIEW.deleteEpProberByECSId",id);
		return rows;
	}
	
	/**
	* @Title: updateEpProberByControlServerId 
	* @Description: 根据太阳能控制器ID修改探测器
	* @param eae    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void updateEpProberByControlServerId(EpProber ep) {
		Map map = new HashMap();
		System.out.println("getControlServerId:"+ep.getControlServerId()+"getChannelNumber:"+ep.getChannelNumber()+"name:"+ep.getName()+"note:"+ep.getNote()+"cycle:"+ep.getCycle()+"position:"+ep.getPosition()+"organId:"+ep.getOrganId());
		map.put("id", ep.getControlServerId());
		map.put("channelNumber", ep.getChannelNumber());
		map.put("name", ep.getName());
		map.put("note", ep.getNote());
		map.put("cycle", ep.getCycle());
		map.put("position", ep.getPosition());
		map.put("organId", ep.getOrganId());
		
		getSqlMapClientTemplate().update(
				"EP_PROBER_VIEW.updateEpProberByControlServerId", map);
	}
	
	/**
	* @Title: selectControlServerIdByProberId 
	* @Description: 根据探测器ID查询太阳能控制器ID
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public String selectControlServerIdByProberId(String id) {
		return (String) getSqlMapClientTemplate().queryForObject(
				"EP_PROBER_VIEW.selectControlServerIdByProberId",id);
	}
	
	/**
	* @Title: listEMDandEpProber 
	* @Description: 根据输电线路ID查询太阳能探测器列表
	* @param @return    设定文件 
	* @return List<ListEpMonitorDeviceAndEpProberVO>    返回类型 
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public List<ListEpMonitorDeviceAndEpProberVO> listEMDandEpProber(String deviceId) {
		System.out.println("id:"+deviceId);
		return getSqlMapClientTemplate().queryForList(
				"EP_PROBER_VIEW.listEMDandEpProber",deviceId);
	}

	/**
	 * 
	* @Title: listProberByOrganId 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param organId
	* @param @return    设定文件 
	* @return List<EpProberVO>    返回类型 
	* @throws
	 */
	public List<EpProberVO>  listProberByOrganId(String organId){
		return getSqlMapClientTemplate().queryForList(
				"EP_PROBER_VIEW.listProberByOrganId",organId);
		
	}

	
	/**
	* @Title: listVicByAssetsId 
	* @Description: 根据探测器ID查询摄像头ID
	* @param assetsId
	* @param @return    设定文件 
	* @return List<ListVicVO>    返回类型 
	* @throws
	 */
	public List<ListVicIdVO> listVicIdByProberId(String proberId) {
		return getSqlMapClientTemplate().queryForList(
				"EP_PROBER_VIEW.listVicIdByProberId",proberId);
	}

}
