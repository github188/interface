/**   
* @Title: ListDeviceByIntelligentResponse.java 
* @Package com.megaeyes.web.response 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-5-14 上午9:42:09 
* @version V1.0   
*/ 
package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.vo.ListDeviceByIntelligentVO;

/** 
 * @ClassName: ListDeviceByIntelligentResponse 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-5-14 上午9:42:09 
 *  
 */
public class ListDeviceByIntelligentResponse extends BaseResponse {

	private List<ListDeviceByIntelligentVO> device;

	public List<ListDeviceByIntelligentVO> getDevice() {
		return device;
	}

	public void setDevice(List<ListDeviceByIntelligentVO> device) {
		this.device = device;
	} 
}
