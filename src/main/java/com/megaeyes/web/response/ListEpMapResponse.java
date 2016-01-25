/**   
 * @Title: ListEpMapResponse.java 
 * @Package com.megaeyes.web.response 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-4-27 下午2:41:56 
 * @version V1.0   
 */
package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.EpMap;

/**
 * @ClassName: ListEpMapResponse
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-4-27 下午2:41:56
 * 
 */
public class ListEpMapResponse extends BaseResponse {
	private List<EpMap> list;
	private String code;

	public List<EpMap> getList() {
		return list;
	}

	public void setList(List<EpMap> list) {
		this.list = list;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
