package com.megaeyes.persistence.ibatis.impl;

import com.megaeyes.persistence.ibatis.iface.EpClientGatewayDAOImpl;
import com.megaeyes.persistence.ibatis.vo.ClientGatewayHeartbeatVO;


/**
 * EpClientGatewayDAOiBatis(类说明)
 * @author tangjianyang tangjianyang@megaeyes.com 
 * <p />
 * 2012-12-27 下午3:47:52
 */
public class EpClientGatewayDAOiBatis extends EpClientGatewayDAOImpl {

	public ClientGatewayHeartbeatVO clientGatewayHeartbeat() {
		return (ClientGatewayHeartbeatVO) getSqlMapClientTemplate().queryForObject(
				"EP_CLIENT_GATEWAY_VIEW.clientGatewayHeartbeat");
	}
}
