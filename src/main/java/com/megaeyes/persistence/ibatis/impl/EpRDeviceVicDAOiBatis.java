package com.megaeyes.persistence.ibatis.impl;

import com.megaeyes.persistence.ibatis.iface.EpRDeviceVicDAOImpl;

public class EpRDeviceVicDAOiBatis extends EpRDeviceVicDAOImpl {
	/**
	 * @Title: countVicRelation 
	 * @Description: 查询摄像头与电力设备的关联个数
	 * 
	 * @param vicId
	 *            摄像头ID
	 * @return
	 */
	public int countVicRelation(String vicId) {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"EP_R_DEVICE_VIC_VIEW.countVicRelation", vicId);
	}
}
