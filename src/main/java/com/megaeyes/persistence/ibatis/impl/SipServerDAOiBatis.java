/**   
 * @Title: SipServerDAOiBatis.java 
 * @Package com.megaeyes.persistence.ibatis.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-4-20 下午4:51:33 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.impl;

import java.math.BigDecimal;
import java.util.List;

import com.megaeyes.persistence.ibatis.iface.SipServerDAOImpl;
import com.megaeyes.persistence.ibatis.model.SipServer;

/**
 * @ClassName: SipServerDAOiBatis
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-4-20 下午4:51:33
 * 
 */
public class SipServerDAOiBatis extends SipServerDAOImpl {
	public int heartBeat(String deviceNumber) {
		SipServer record = new SipServer();
		record.setDeviceNumber(deviceNumber);
		record.setHeartbeatTime(new BigDecimal(System.currentTimeMillis()));
		return getSqlMapClientTemplate().update("SIP_SERVER_VIEW.heartbeat",
				record);
	}

	/**
	 * 
	 * listSipServer 查询信令网关列表
	 * @return List<SipServer>
	 */
	public List<SipServer> listSipServer() {
		return getSqlMapClientTemplate().queryForList(
		"SIP_SERVER_VIEW.listSipServer");
	}

}
