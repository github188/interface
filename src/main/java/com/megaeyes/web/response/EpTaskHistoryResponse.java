/**   
 * @Title: EpTaskHistoryResponse.java 
 * @Package com.megaeyes.web.response 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-5-16 下午6:09:37 
 * @version V1.0   
 */
package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.EpTaskHistory;

/**
 * @ClassName: EpTaskHistoryResponse
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-5-16 下午6:09:37
 * 
 */
public class EpTaskHistoryResponse extends BaseResponse {
	private List<EpTaskHistory> list;
	private String code;

	public List<EpTaskHistory> getList() {
		return list;
	}

	public void setList(List<EpTaskHistory> list) {
		this.list = list;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
