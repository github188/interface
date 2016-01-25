package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.TempResources;

/**
 * 获取第三方平台资源接口返回对象
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2012-7-19 下午02:00:31
 */
public class ListThirdPartResourceResponse extends BaseResponse {
	private List<TempResources> resources;

	public List<TempResources> getResources() {
		return resources;
	}

	public void setResources(List<TempResources> resources) {
		this.resources = resources;
	}
}
