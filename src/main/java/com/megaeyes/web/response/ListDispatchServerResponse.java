/**   
* @Title: ListDispatchServerResponse.java 
* @Package com.megaeyes.web.response 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-3-2 上午5:53:40 
* @version V1.0   
*/ 
package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.DispatchServer;



/** 
 * @ClassName: ListDispatchServerResponse 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-3-2 上午5:53:40 
 *  
 */
public class ListDispatchServerResponse extends BaseResponse {
	public List<DispatchServer> getServers() {
		return servers;
	}

	public void setServers(List<DispatchServer> servers) {
		this.servers = servers;
	}

	private List<DispatchServer> servers;
	private String code;

	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
