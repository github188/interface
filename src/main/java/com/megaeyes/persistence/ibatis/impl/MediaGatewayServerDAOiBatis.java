package com.megaeyes.persistence.ibatis.impl;

import java.util.List;

import com.megaeyes.persistence.ibatis.iface.MediaGatewayServerDAOImpl;
import com.megaeyes.persistence.ibatis.model.MediaGatewayServer;

/**
 * MediaGatewayServerDAOiBatis(类说明)
 * @author wangbinyu wangbinyu@megaeyes.com
 * <p />
 * 2012-7-19 上午06:19:03
 */
public class MediaGatewayServerDAOiBatis extends MediaGatewayServerDAOImpl {

	/**
	 * 
	 * listMediaGatewayServer 查询媒体网关列表
	 * @return List<MediaGatewayServer>
	 */
	public List<MediaGatewayServer> listMediaGatewayServer() {
		return getSqlMapClientTemplate().queryForList(
		"MEDIA_GATEWAY_SERVER_VIEW.listMediaGatewayServer");
	}

}
