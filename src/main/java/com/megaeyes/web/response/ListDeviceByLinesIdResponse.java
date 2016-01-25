/**   
* @Title: ListDeviceByLinesIdResponse.java 
* @Package com.megaeyes.web.response 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-5-7 上午1:50:28 
* @version V1.0   
*/ 
package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.vo.ListVicVO;

/** 
 * @ClassName: ListDeviceByLinesIdResponse 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-5-7 上午1:50:28 
 *  
 */
public class ListDeviceByLinesIdResponse extends BaseResponse {
	private List<ListVicVO> device;
	public List<ListVicVO> getDevice() {
		return device;
	}
	public void setDevice(List<ListVicVO> device) {
		this.device = device;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	private String code;
}
