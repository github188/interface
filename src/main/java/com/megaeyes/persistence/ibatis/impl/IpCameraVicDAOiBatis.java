package com.megaeyes.persistence.ibatis.impl;

import java.util.HashMap;
import java.util.Map;

import com.megaeyes.persistence.ibatis.iface.IpCameraVicDAOImpl;
import com.megaeyes.persistence.ibatis.model.IpCameraVic;

/**
 * @ClassName: IpCameraVicDAOiBatis
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-3-21 下午5:03:40
 * 
 */
public class IpCameraVicDAOiBatis extends IpCameraVicDAOImpl {

	public void updateIpCameraVicByVisId(IpCameraVic ipVic,String visId) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("visId", visId);
		param.put("password", ipVic.getPassword());
		param.put("deviceType", ipVic.getDeviceType());
		param.put("sdSupport", ipVic.getSdSupport());
		getSqlMapClientTemplate().update("IP_CAMERA_VIC.updateIpCameraVicByVisId", param);
	}
}
