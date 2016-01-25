package com.megaeyes.web.response.xml;

import java.util.ArrayList;
import java.util.List;

import com.megaeyes.persistence.ibatis.model.ThirdPartyPlatform;

/**
 * 信令网关心跳返回
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2012-5-2 下午01:26:00
 */
public class SipServerHeartbeatResponse extends BaseXMLResponse {
	private List<ThirdPartyPlatform> platformList = new ArrayList<ThirdPartyPlatform>();

	public List<ThirdPartyPlatform> getPlatformList() {
		return platformList;
	}

	public void setPlatformList(List<ThirdPartyPlatform> platformList) {
		this.platformList = platformList;
	}
}
