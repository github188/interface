package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.ThirdPartyPlatform;

/**
 * 获取所有的下级平台返回对象
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2012-7-20 上午09:58:47
 */
public class ListThirdPartyPlatformResponse extends BaseResponse {
	private List<ThirdPartyPlatform> platforms;

	public List<ThirdPartyPlatform> getPlatforms() {
		return platforms;
	}

	public void setPlatforms(List<ThirdPartyPlatform> platforms) {
		this.platforms = platforms;
	}
}
