/**   
* @Title: ListEpDeviceResponse.java 
* @Package com.megaeyes.web.response 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-4-28 上午8:31:27 
* @version V1.0   
*/ 
package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.EpDevice;

/** 
 * @ClassName: ListEpDeviceResponse 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-4-28 上午8:31:27 
 *  
 */
public class ListEpDeviceResponse extends BaseResponse {
	private List<EpDevice> epDevice;

	public List<EpDevice> getEpDevice() {
		return epDevice;
	}

	public void setEpDevice(List<EpDevice> epDevice) {
		this.epDevice = epDevice;
	}
}
