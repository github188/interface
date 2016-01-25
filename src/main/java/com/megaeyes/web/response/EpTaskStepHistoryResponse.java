/**   
 * @Title: EpTaskStepHistoryResponse.java 
 * @Package com.megaeyes.web.response 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-5-17 下午3:58:12 
 * @version V1.0   
 */
package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.EpTaskStepHistory;

/**
 * @ClassName: EpTaskStepHistoryResponse
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-5-17 下午3:58:12
 * 
 */
public class EpTaskStepHistoryResponse extends BaseResponse {
	private List<EpTaskStepHistory> list;
	private String code;

	public List<EpTaskStepHistory> getList() {
		return list;
	}

	public void setList(List<EpTaskStepHistory> list) {
		this.list = list;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
