/**   
 * @Title: EpTaskInspectionResponse.java 
 * @Package com.megaeyes.web.response 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-5-7 下午5:33:25 
 * @version V1.0   
 */
package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.EpTaskInspection;

/**
 * @ClassName: EpTaskInspectionResponse
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-5-7 下午5:33:25
 * 
 */
public class EpTaskInspectionResponse extends BaseResponse {
	private List<EpTaskInspection> list;
	private String code;

	public List<EpTaskInspection> getList() {
		return list;
	}

	public void setList(List<EpTaskInspection> list) {
		this.list = list;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
