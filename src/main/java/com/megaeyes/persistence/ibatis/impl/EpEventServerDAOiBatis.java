/**   
 * @Title: EpEventServerDAOiBatis.java 
 * @Package com.megaeyes.persistence.ibatis.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author wangbinyu wangbinyu@megaeyes.com   
 * @date 2012-3-19 上午2:33:37 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.megaeyes.persistence.ibatis.iface.EpEventServerDAOImpl;
import com.megaeyes.persistence.ibatis.model.AccessServer;
import com.megaeyes.persistence.ibatis.model.EpEventServer;

/**
 * @ClassName: EpEventServerDAOiBatis
 * @Description: 事件服务器
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-3-19 上午2:33:37
 * 
 */
public class EpEventServerDAOiBatis extends EpEventServerDAOImpl {
	/**
	 * @Title: listEpEventServer
	 * @Description: 查询所有事件服务器列表
	 * @return List<EpEventServer> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<EpEventServer> listEpEventServer() {
		return getSqlMapClientTemplate().queryForList(
				"EP_EVENT_SERVER_VIEW.listEpEventServer");
	}

	public void updateEventServerByDeviceNumber(String deviceNumber,
			String ip1, String ip2, Long port,BigDecimal heartbeatTime) {
		Map map = new HashMap();
		map.put("deviceNumber", deviceNumber);
		map.put("ip1", ip1);
		map.put("ip2", ip2);
		map.put("heartbeatTime", heartbeatTime);
		map.put("port", port);
		getSqlMapClientTemplate().update(
				"EP_EVENT_SERVER_VIEW.updateEventServerByDeviceNumber", map);
	}
}
