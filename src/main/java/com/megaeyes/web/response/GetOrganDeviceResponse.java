/**   
 * @Title: GetOrganDeviceResponse.java 
 * @Package com.megaeyes.web.response 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author liugaofeng liugaofeng@megaeyes.com   
 * @date 2012-3-19 下午3:56:49 
 * @version V1.0   
 */
package com.megaeyes.web.response;

import com.megaeyes.web.response.organdevicetree.OrganNode;

/**
 * @ClassName: GetOrganDeviceResponse
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author liugaofeng liugaofeng@megaeyes.com
 * @date 2012-3-19 下午3:56:49
 * 
 */
public class GetOrganDeviceResponse extends BaseResponse {
	private OrganNode root;

	public OrganNode getRoot() {
		return root;
	}

	public void setRoot(OrganNode root) {
		this.root = root;
	}
}
