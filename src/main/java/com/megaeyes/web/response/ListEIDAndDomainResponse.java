/**   
* @Title: ListEIDAndDomainResponse.java 
* @Package com.megaeyes.web.response 
* @Description: TODO(用一句话描述该文件做什么) 
* @author liugaofeng liugaofeng@megaeyes.com   
* @date 2012-5-9 下午5:38:59 
* @version V1.0   
*/ 
package com.megaeyes.web.response;

import com.megaeyes.web.response.organdevicetree.epdevice.DeviceNode;

/** 
 * @ClassName: ListEIDAndDomainResponse 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author liugaofeng liugaofeng@megaeyes.com 
 * @date 2012-5-9 下午5:38:59 
 *  
 */
public class ListEIDAndDomainResponse extends BaseResponse {
	private DeviceNode root;

	public DeviceNode getRoot() {
		return root;
	}

	public void setRoot(DeviceNode root) {
		this.root = root;
	}
	
	
}
