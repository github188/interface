/**   
* @Title: ListEpMonitorDeviceAndEpProber.java 
* @Package com.megaeyes.web.response 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-5-9 上午1:25:03 
* @version V1.0   
*/ 
package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.vo.ListEpMonitorDeviceAndEpProberVO;

/** 
 * @ClassName: ListEpMonitorDeviceAndEpProber 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-5-9 上午1:25:03 
 *  
 */
public class ListEpMonitorDeviceAndEpProber extends BaseResponse {
	
	private List<ListEpMonitorDeviceAndEpProberVO> prober;
	
	public List<ListEpMonitorDeviceAndEpProberVO> getProber() {
		return prober;
	}

	public void setProber(List<ListEpMonitorDeviceAndEpProberVO> prober) {
		this.prober = prober;
	}


}
