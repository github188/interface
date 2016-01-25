/**   
 * @Title: ListIpVicResponse.java 
 * @Package com.megaeyes.web.response 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-3-26 下午4:05:14 
 * @version V1.0   
 */
package com.megaeyes.web.response;

import java.util.List;

/**
 * @ClassName: ListIpVicResponse
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-3-26 下午4:05:14
 * 
 */
public class ListIpVicResponse extends BaseResponse {
	private List<IpVICResponse> vics;
	private String code;

	public List<IpVICResponse> getVics() {
		return vics;
	}

	public void setVics(List<IpVICResponse> vics) {
		this.vics = vics;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
