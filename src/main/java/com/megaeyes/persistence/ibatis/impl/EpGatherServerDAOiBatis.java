/**   
 * @Title: EpGatherServerDAOiBatis.java 
 * @Package com.megaeyes.persistence.ibatis.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author wangbinyu wangbinyu@megaeyes.com   
 * @date 2012-3-21 上午5:23:01 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.impl;

import java.util.List;

import com.megaeyes.persistence.ibatis.iface.EpGatherServerDAOImpl;
import com.megaeyes.persistence.ibatis.model.EpGatherServer;

/**
 * @ClassName: EpGatherServerDAOiBatis
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-3-21 上午5:23:01
 * 
 */
public class EpGatherServerDAOiBatis extends EpGatherServerDAOImpl {
	/**
	 * @Title: listEpGatherServer
	 * @Description: 查询采集服务器列表
	 * @return List<EpGatherServer> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<EpGatherServer> listEpGatherServer() {
		return getSqlMapClientTemplate().queryForList(
				"EP_GATHER_SERVER_VIEW.listEpGatherServer");
	}

	/**
	 * 根据物理编号获取采集服务器
	 * 
	 * @param deviceNumber
	 *            物理编号
	 * @return
	 */
	public EpGatherServer getByDeviceNumber(String deviceNumber) {
		return (EpGatherServer) getSqlMapClientTemplate().queryForObject(
				"EP_GATHER_SERVER_VIEW.getByDeviceNumber", deviceNumber);
	}
}
