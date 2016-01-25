/**   
* @Title: ListPLCResponse.java 
* @Package com.megaeyes.web.response 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-5-10 上午5:56:53 
* @version V1.0   
*/ 
package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.EpControlServer;

/** 
 * @ClassName: ListPLCResponse 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-5-10 上午5:56:53 
 *  
 */
public class ListPLCResponse extends BaseResponse {
	private List<EpControlServer> plc;

	public List<EpControlServer> getPlc() {
		return plc;
	}

	public void setPlc(List<EpControlServer> plc) {
		this.plc = plc;
	}


}
