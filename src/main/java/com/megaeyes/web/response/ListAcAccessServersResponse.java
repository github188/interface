/**   
* @Title: ListAcAccessServersResponse.java 
* @Package com.megaeyes.web.response 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-5-15 上午2:07:37 
* @version V1.0   
*/ 
package com.megaeyes.web.response;

import java.util.List;
import com.megaeyes.persistence.ibatis.model.AcAccessServers;
/** 
 * @ClassName: ListAcAccessServersResponse 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-5-15 上午2:07:37 
 *  
 */
public class ListAcAccessServersResponse extends BaseResponse {

	private List<AcAccessServers> AcAccessServers;

	public List<AcAccessServers> getAcAccessServers() {
		return AcAccessServers;
	}

	public void setAcAccessServers(List<AcAccessServers> acAccessServers) {
		AcAccessServers = acAccessServers;
	}
}
