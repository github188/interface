/**   
* @Title: ListEpEventServerResponse.java 
* @Package com.megaeyes.web.response 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-3-19 上午6:08:25 
* @version V1.0   
*/ 
package com.megaeyes.web.response;

import java.util.ArrayList;
import java.util.List;

import com.megaeyes.persistence.ibatis.model.AccessServer;
import com.megaeyes.persistence.ibatis.model.EpEventServer;

/** 
 * @ClassName: ListEpEventServerResponse 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-3-19 上午6:08:25 
 *  
 */
public class ListEpEventServerResponse extends BaseResponse {
	private List<EpEventServer> epEventServer;

	public List<EpEventServer> getEpEventServer() {
		return epEventServer;
	}
	public void setEpEventServer(List<EpEventServer> epEventServer) {
		this.epEventServer = epEventServer;
	}
	
	
}
