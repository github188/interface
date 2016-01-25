/**   
 * @Title: AcGatewayResponse.java 
 * @Package com.megaeyes.web.response 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-5-14 下午5:06:16 
 * @version V1.0   
 */
package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.AcGateway;

/**
 * @ClassName: AcGatewayResponse
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-5-14 下午5:06:16
 * 
 */
public class AcGatewayResponse extends BaseResponse {
	private List<AcGateway> list;
	private String code;

	public List<AcGateway> getList() {
		return list;
	}

	public void setList(List<AcGateway> list) {
		this.list = list;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
