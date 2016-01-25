/**   
* @Title: ListEpGatherServerResponse.java 
* @Package com.megaeyes.web.response 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-3-21 上午8:44:29 
* @version V1.0   
*/ 
package com.megaeyes.web.response;

import java.util.ArrayList;
import java.util.List;


import com.megaeyes.persistence.ibatis.model.EpGatherServer;

/** 
 * @ClassName: ListEpGatherServerResponse 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-3-21 上午8:44:29 
 *  
 */
public class ListEpGatherServerResponse extends BaseResponse {
	private List<EpGatherServer> epGatherServer;
	private String code;
	public List<EpGatherServer> getEpGatherServer() {
		return epGatherServer;
	}
	public void setEpGatherServer(List<EpGatherServer> epGatherServer) {
		this.epGatherServer = epGatherServer;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
