/**   
* @Title: ListAccessServerResponse.java 
* @Package com.megaeyes.web.response 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-3-1 上午2:14:36 
* @version V1.0   
*/ 
package com.megaeyes.web.response;

import java.util.ArrayList;
import java.util.List;

import com.megaeyes.persistence.ibatis.model.AccessServer;





/** 
 * @ClassName: ListAccessServerResponse 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-3-1 上午2:14:36 
 *  
 */
public class ListAccessServerResponse extends BaseResponse {
	private List<AccessServer> accessServer = new ArrayList();
	private String code;
	public List<AccessServer> getAccessServer() {
		return accessServer;
	}
	public void setAccessServer(List<AccessServer> accessServer) {
		this.accessServer = accessServer;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
