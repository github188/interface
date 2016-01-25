/**   
* @Title: EpControlServerDAOiBatis.java 
* @Package com.megaeyes.persistence.ibatis.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-5-7 上午7:52:17 
* @version V1.0   
*/ 
package com.megaeyes.persistence.ibatis.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.megaeyes.persistence.ibatis.iface.EpControlServerDAOImpl;
import com.megaeyes.persistence.ibatis.model.EpControlServer;
import com.megaeyes.persistence.ibatis.model.EpProber;

/** 
 * @ClassName: EpControlServerDAOiBatis 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-5-7 上午7:52:17 
 *  
 */
public class EpControlServerDAOiBatis extends EpControlServerDAOImpl {
	
	
	public void updateECSurlByProberId(EpControlServer ecs) {
		Map map = new HashMap();
		map.put("id", ecs.getId());
		map.put("url",ecs.getUrl());
		
		getSqlMapClientTemplate().update(
				"EP_PROBER_VIEW.updateECSurlByProberId", map);
	}

	/**
	* @Title: listPLCByGatherServerId 
	* @Description: 根据采集服务器ID查询PLC列表 
	* @param gatherServerId 采集服务器ID
	* @return List<EpControlServer>    返回类型 
	* @throws
	 */
	public List<EpControlServer> listPLCByGatherServerId(String serverId) {
		return getSqlMapClientTemplate().queryForList(
				"EP_CONTROL_SERVER_VIEW.listPLCByGatherServerId",serverId);
	}
}
